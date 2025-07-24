package com.vv.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vv.entity.User;
import lombok.var;

import java.util.Date;
import java.util.Map;

public class JwtUtil {


    //密钥
    private static final String SECRET_KEY = "vv";

    // 过期时间60分钟
    private static final long EXPIRE_TIME = 60 * 60 * 1000;

    /**
     * 生成签名
     *
     * @param claims
     * @return
     */
    public static String generateToken(Map<String, Object> claims) {
        var jwtBuilder = JWT.create();

        // 设置传入的字典中的声明
        for (Map.Entry<String, Object> entry : claims.entrySet()) {

            jwtBuilder.withClaim(entry.getKey(), entry.getValue().toString());
        }

        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        return jwtBuilder.withExpiresAt(date).sign(algorithm);


    }

    /**
     * 校验token是否正确
     *
     * @param token
     * @return
     */
    public static boolean verifyToken(String token) {
        try {

            if (token.startsWith("Bearer ")) {

                token = token.replace("Bearer ", "");
                return false;
            }
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的用户信息（无需secret解密也能获得）
     *
     * @param token
     * @return
     */
    public static User getUserIdAndRole(String token) {

        try {

            if (token.startsWith("Bearer ")) {
                token = token.replace("Bearer ", "");
            }
            DecodedJWT jwt = JWT.decode(token);

            String role = jwt.getClaim("role").asString();
            String userId = jwt.getClaim("userId").asString();
            User user = new User(role,userId);
            return user;
        } catch (JWTDecodeException e) {

            return null;
        }
    }
}