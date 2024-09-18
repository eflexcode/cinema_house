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
		SpringApplication.run(CinemaHouseApplication.class, args);
	}
}
