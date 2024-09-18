package com.ifeanyi.cinema_house;

import com.ifeanyi.cinema_house.auth.Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CinemaHouseApplication {

	public static void main(String[] args) {
//		System.out.println(generateToken("66e77edc1f3f7b001f0200ad"));
		SpringApplication.run(CinemaHouseApplication.class, args);
	}
//	private static final long jwtExpTime1Day = 60*60*24*1000; // 1 day
//
//	public static String generateToken(String userId){
//		Map<String,Object> claims = new HashMap<>();
//
//		return Jwts.builder()
//				.addClaims(claims)
//				.setSubject(userId)
//				.setIssuedAt(new Date())
//				.setExpiration(new Date(System.currentTimeMillis()+jwtExpTime1Day))
//				.signWith(signInKey(Util.secret), SignatureAlgorithm.HS512)
//				.compact();
//	}
//	public static Key signInKey(String key){
//		byte[] bytesKey = key.getBytes(StandardCharsets.UTF_8);
//		return Keys.hmacShaKeyFor(bytesKey);
//	}
}
