package com.practice.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = "com.practice.entity")
public class SecurityConfig
{
	@Bean public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(
			(request)->request
				.requestMatchers("/**").permitAll()
				.anyRequest().authenticated()
		);
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		http.csrf((customize)->customize.disable());
		http.headers((headers)->headers.frameOptions((frameOptions)->frameOptions.disable()));
		return http.build();
	}
}
