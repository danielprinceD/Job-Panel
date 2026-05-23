package com.practice.security.jwtauth;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Key;
import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils
{

	@Value("${spring.security.jwt.secret}")
	private String secretKey;

	@Value("${spring.security.jwt.expiration}")
	private String expirationTime;

	public Key getKey(){
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}

	public String generateJswtTokenFromUserName(UserDetails userDetails){
		return Jwts.builder()
			.setSubject(userDetails.getUsername())
			.setIssuedAt(new Date())
			.setExpiration(new Date(new Date().getTime() + Long.parseLong(expirationTime)))
			.signWith(getKey())
			.compact();
	}

	public String getJwtTokenFromHeader(HttpServletRequest request){
		String authHeader = request.getHeader("Authorization");
		if(authHeader != null && authHeader.startsWith("Bearer ")){
			return authHeader.substring(7);
		}
		return null;
	}

	public String getUsernameFromJwtToken(String token){
		return Jwts.parserBuilder()
			.setSigningKey(getKey())
			.build()
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}

	public boolean validateJwtToken(String token){
		try{
			Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
			return true;
		}
		catch(JwtException e){
			throw new JwtException(e.getMessage());
		}
	}

}
