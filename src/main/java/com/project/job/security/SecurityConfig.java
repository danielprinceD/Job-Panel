package com.project.job.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.project.job.pojo.Job;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig
{

	@Autowired
	DataSource dataSource;

	public static final String[] exclueList = {
		"/h2-console/**", "/**"
	};

	@Bean
	public SecurityFilterChain _webSecurityFilter(HttpSecurity http) throws Exception
	{
		System.out.println("SecurityFilterChain Bean Created");
		http.authorizeHttpRequests(
			(request)->request
				.requestMatchers(exclueList).permitAll()
				.anyRequest().authenticated()
		);
		http.formLogin((Customizer.withDefaults()));
		http.httpBasic(Customizer.withDefaults());
		http.headers((headers)->headers.frameOptions((frameOptions)->frameOptions.sameOrigin()));
		http.csrf(csrf->csrf.disable());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public UserDetailsService userDetailsService(){
//		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//		UserDetails user = User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build();
//		UserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//		userDetailsManager.createUser(admin);
//		userDetailsManager.createUser(user);
//
//		return userDetailsManager;
//	}
}
