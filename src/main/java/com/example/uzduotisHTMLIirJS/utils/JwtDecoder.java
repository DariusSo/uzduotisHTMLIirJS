package com.example.uzduotisHTMLIirJS.utils;

import com.example.uzduotisHTMLIirJS.models.Transaction;
import com.example.uzduotisHTMLIirJS.repositories.TransactionRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.sql.SQLException;
import java.util.UUID;

public class JwtDecoder {

    private static final String SECRET_KEY = "9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";

    public static Claims decodeJwt(String jwt) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        return claims;
    }
    public static boolean authorization(String authString, String endpoint, String request){
        try{
            Claims claims = JwtDecoder.decodeJwt(authString);
        }catch (JwtException e){
            return false;
        }
        return true;
    }
}
