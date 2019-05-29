package com.loser.ecommerce.service.impl;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.loser.ecommerce.jwt.JwtInfoEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author pwd
 * @create 2019-03-23 15:49
 **/
public class PwdTest {
    @Test
    public void test() {
        LocalDate date1 = LocalDate.parse("2019-03-31");
        LocalDate date2 = LocalDate.parse("2019-05-01");
        long between = ChronoUnit.DAYS.between(date1, date2);
        System.out.println(between);
    }

    @Test
    public void test2() {
        String key = "abadsfasdf1";
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
        JwtBuilder builder = Jwts.builder()
                .setSubject("潘伟丹")
                .setIssuedAt(now)
                .setAudience("123")
                .claim("age", 34)
                .signWith(SignatureAlgorithm.HS512, signingKey);
        long expMillis = nowMillis + 3600;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp).setNotBefore(now);
        String token = builder.compact();

        System.out.println("token " + token);

        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        System.out.println(claims);
    }

}
