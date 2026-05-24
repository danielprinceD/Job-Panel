package com.practice.security.signin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.security.jwtauth.JwtUtils;

@RestController
public class RegistrationController
{

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired private PasswordEncoder bcrypt;

	@Autowired private UserDetailsManager userDetailsManager;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/signup")
	public ResponseEntity registerUser(@RequestBody LoginDetails loginDetails)
	{
		UserDetails userDetails = User.withUsername(loginDetails.getUsername())
			.password(bcrypt.encode(loginDetails.getPassword()))
			.roles(loginDetails.getRoles().toArray(new String[0]))
			.build();

		userDetailsManager.createUser(userDetails);

		return ResponseEntity.ok(Map.of(
			"status" , 201,
			"message" , "SignUp Success",
			"username" , loginDetails.getUsername(),
			"roles" , loginDetails.getRoles()
		));
	}

	@PostMapping("/signin")
	public ResponseEntity loginUser(@RequestBody LoginDetails loginDetails)
	{
		Authentication authentication;
		try{
			System.out.println(loginDetails.getUsername() + " " + loginDetails.getPassword() + " " + loginDetails.getRoles());
			authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					loginDetails.getUsername(),
					loginDetails.getPassword()
				)

			);
		}
		catch(Exception e){
			System.out.println(Arrays.toString(e.getStackTrace()));
			return ResponseEntity.badRequest().body(Map.of(
				"status" , 400,
				"message" , "SignUp Failed",
				"exception" , e.getMessage()
			));

		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtUtils.generateJswtTokenFromUserName(userDetails);
		List<String> roles = userDetails.getAuthorities().stream().map(
			auth->auth.getAuthority()
		).toList();
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setMessage(Map.of(
			"status" , 201,
			"message" , "SignUp Success",
			"username" , userDetails.getUsername(),
			"roles" , roles
		));
		loginResponse.setToken(token);
		return ResponseEntity.ok(loginResponse);
	}
}
