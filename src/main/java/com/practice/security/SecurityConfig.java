package com.practice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	public SecurityFilterChain _webSecurityFilter(HttpSecurity http) throws Exception
	{
		System.out.println("SecurityFilterChain Bean Created");
		http.authorizeHttpRequests((request)->request.anyRequest().authenticated());
		http.formLogin((Customizer.withDefaults()));
		http.httpBasic(Customizer.withDefaults());
		http.csrf((customize)->customize.disable());
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
		UserDetails user1 = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("USER").build();
		UserDetails user2 = User.withUsername("admin1").password(passwordEncoder().encode("admin1")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user1 , user2);
	}

}
