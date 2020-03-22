package com.fz6m.answer.fz6m.utils;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Token {

    private static final String SECRET = "police_key_secret";//私密key
    private static final Long TTL_EXPIRATION = 1000L * 60 * 30; //过期时间30分钟
    private static final String ISSUER = "police";//发行人

    /**
     * 加密信息，生成token
     */
    public static String creatToken(Map<String,Object> params) {
        SignatureAlgorithm signature = SignatureAlgorithm.HS256;

        byte[] secretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key secretKey = new SecretKeySpec(secretBytes, signature.getJcaName());
        Long expiration = System.currentTimeMillis() + TTL_EXPIRATION;

        JwtBuilder builder = Jwts.builder()
                .setClaims(params)
                .setIssuedAt(new Date())
                .setExpiration(new Date(expiration))
                .setIssuer(ISSUER)
                .signWith(signature,secretKey);

        return builder.compact();
    }

    /**
     * 解析token
     */
    public static Object parseToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                    .parseClaimsJws(token).getBody();
        } catch (SignatureException | MalformedJwtException e){
            // System.out.println("token解析失败");
            Map<String,Object> map = new HashMap<>();
            map.put("status",0);
            return map;
        } catch (ExpiredJwtException e) {
            // System.out.println("token已过期");
            Map<String,Object> map = new HashMap<>();
            map.put("status",-1);
            return map;
        }
        return claims;
    }


}