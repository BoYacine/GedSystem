package com.yacine.GedSystem.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class jwtService {

    //------token information---------
    private final String CLAIMS_SUBJECT="sub";
    private final String CLAMS_CREATED="created";
    //@Value("{$auth.expiration}")
    private long TOKEN_VALIDITY= 30L;
    //@Value("{$auth.secret}")
    private String TOKEN_SECRET="665468576D5A7134743777217A25432A462D4A614E645267556B587032723575";

    //------generate token---------
    public String generateToken(UserDetails uderUserDetails){
        Map<String,Object>claims = new HashMap<>();
        claims.put(CLAIMS_SUBJECT,uderUserDetails.getUsername());
        claims.put(CLAMS_CREATED,new Date());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationData())
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Date generateExpirationData() {
        return new Date(System.currentTimeMillis()+TOKEN_VALIDITY*1000*60);
    }

    private Key getSignKey() {
        byte[] keyBytes= Decoders.BASE64.decode(TOKEN_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    //------extract info from token---------

    private Claims getClaims(String token){
        Claims claims;
        try {
            claims=Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            claims= null;
        }
        return claims;
    }

    public String getUsernameFromToken(String token){
        try {
            Claims claims=getClaims(token);
            return claims.getSubject();
        }catch (Exception e){
            return null;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }












}
