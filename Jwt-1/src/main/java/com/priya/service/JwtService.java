package com.priya.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
	String secreteKey;
	public JwtService()
	{
		try {
			KeyGenerator generator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = generator.generateKey();
			secreteKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		} 
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		
	}
	public String generateTokens(String username) 
	{
		Map<String,Object> claims = new HashMap<>();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+60+60+30))
				.and()
				.signWith(getKey())
				.compact();
		
	}
	private Key getKey() 
	{
		byte[] key = Decoders.BASE64.decode(secreteKey);
		return Keys.hmacShaKeyFor(key);
	}

}
