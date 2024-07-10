package com.example.uzduotisHTMLIirJS.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

public class JwtGenerator {

    private static final String SECRET_KEY = "9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";
    private static final String SECRET_KEY_DELETE_MODIFY = "dfgsdfgdsfgsdfgdsfgsdfgdsfgsdfgd4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";

    public static String generateJwt(String username, String password, int userId) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date exp = new Date(nowMillis + 120 * 60 * 1000); // 120 minutes

        String jwt = Jwts.builder()
                .setIssuer("manokompanija.eu")
                .setSubject("manokompanija.eu")
                .claim("Username", username)
                .claim("Password", password)
                .claim("UserId", String.valueOf(userId))
                .claim("DateOfLogin", new java.text.SimpleDateFormat("yyyy-MM-dd").format(now))
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }
    public static String generateJwtModifyDelete(String username, String password, int userId) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY_DELETE_MODIFY.getBytes(StandardCharsets.UTF_8));

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date exp = new Date(nowMillis + 120 * 60 * 1000); // 120 minutes

        String jwt = Jwts.builder()
                .setIssuer("manokompanija.eu")
                .setSubject("manokompanija.eu")
                .claim("Username", username)
                .claim("Password", password)
                .claim("UserId", String.valueOf(userId))
                .claim("DateOfLogin", new java.text.SimpleDateFormat("yyyy-MM-dd").format(now))
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }
}
