package com.ifeanyi.cinema_house.auth.service;

import com.ifeanyi.cinema_house.auth.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final long jwtExpTime1Day = 60*60*24*1000; // 1 day
    private final long  jwtExpTime1Hour = 60*60*1000; // 1 hour

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public Key signInKey(String key){
        byte[] bytesKey = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(bytesKey);
    }

    public  <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = Jwts.parserBuilder().setSigningKey(signInKey(Util.secret)).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public Date extractDate(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    private boolean isTokenExpired(String token){
        final Date date = extractDate(token);
        return date.before(new Date());
    }

    public boolean verifyToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String generateToken(String userId){
        Map<String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .addClaims(claims)
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpTime1Hour))
                .signWith(signInKey(Util.secret), SignatureAlgorithm.ES512)
                .compact();
    }
}
