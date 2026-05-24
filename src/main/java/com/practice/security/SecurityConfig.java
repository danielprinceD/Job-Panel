package com.practice.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.practice.security.jwtauth.AuthEntryPointJwt;
import com.practice.security.jwtauth.AuthTokenFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	private static final String[] excludeString =  {
		"/h2-console/**",
		"/signup",
		"/signin"
	};

	@Autowired
	DataSource dataSource;

	@Autowired
	private AuthEntryPointJwt authEntryPointJwt;

	@Bean
	public AuthTokenFilter authTokenFilter(){
		return new AuthTokenFilter();
	}

	@Bean
	public SecurityFilterChain _webSecurityFilter(HttpSecurity http) throws Exception
	{
		System.out.println("SecurityFilterChain Bean Created");
		http.authorizeHttpRequests(
			(request)->request
				.requestMatchers(excludeString).permitAll()
				.anyRequest().authenticated()
		);
//		http.formLogin((Customizer.withDefaults()));
		http.httpBasic(Customizer.withDefaults());
		http.csrf((customize)->customize.disable());
		http.headers(
			header->header.frameOptions(
				frameOption->frameOption.sameOrigin()
			)
		);
		http.oauth2Login(configurer->configurer.defaultSuccessUrl("/hello"));
//		http.exceptionHandling(
//			exception->exception.authenticationEntryPoint(authEntryPointJwt)
//		);
//		http.addFilterBefore(authTokenFilter() , UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService()
	{
		System.out.println("UserDetailsService Bean Created");
//		UserDetails user2 = User.withUsername("admin1").password(passwordEncoder().encode("admin1")).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user1 , user2);
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService ,PasswordEncoder passwordEncoder ) throws Exception{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return new ProviderManager(provider);
	}


}
