package com.example.Noble.JournalServer.Security;
//TODO: This was created by AI for expediency. Go Back through this code to understand it.

import com.example.Noble.JournalServer.User.Registration.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.base64-secret}")
    private String secret;

    public String generateToken(UserDetails userDTO) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDTO.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationTimeInMillis = 1000 * 60 * 60; // 1 hour
        Date expirationDate = new Date(currentTimeMillis + expirationTimeInMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public Boolean validateToken(String token, UserDTO userDTO) {
        final String email = extractClaim(token, Claims::getSubject);
        return (email.equals(userDTO.getEmailAddress()) && !isTokenExpired(token));
    }

}
