package org.roronoa.youbooking.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.roronoa.youbooking.entity.UserApp;
import org.roronoa.youbooking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtils {
    @Autowired
    private IUserService userService;
    private String jwtSingningKey = "d6981c7290ebed5a1fb91cec0b18c2f0";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    public boolean hasClaim(String token, String claimName){
        final  Claims claims = extractAllClaims(token);
        return claims.get(claimName) != null;
    }

    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(jwtSingningKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        UserApp userApp = userService.getUser(userDetails.getUsername());
        claims.put("userId",userDetails.getUsername());
        claims.put("name",userApp.getFullName());
        claims.put("role",userApp.getRole().getName());
        return createToken(claims,userDetails);
    }

    private String createToken(Map<String,Object> claims, UserDetails userDetails){

        return Jwts.builder().setClaims(claims)
                .setSubject("YouBooking")
                .claim("authorities",userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(5)))
                .signWith(SignatureAlgorithm.HS256,jwtSingningKey).compact();
    }

    public Boolean isTokenValid(String token , UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
