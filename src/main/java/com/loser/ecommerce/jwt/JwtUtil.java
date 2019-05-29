package com.loser.ecommerce.jwt;

import com.loser.ecommerce.exception.RetailException;
import com.loser.ecommerce.exception.RetailExceptionEnum;
import com.loser.ecommerce.shiro.ShiroUsers;
import com.loser.ecommerce.util.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class JwtUtil {

    private final static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    //有效期
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;//7天
    private static final String KEY = "@loser:15800225592";
    private static final String tokenHeader = "Token ";

    /**
     * Subject:jwtUser.getUsername()
     * setIssuedAt: Date.now
     * Audience:jwtUser.getPassword()
     * claim:"ROLES",jwtUser.getRole()
     *
     * @param shiroUsers
     * @return
     */
    public static String createToken(ShiroUsers shiroUsers) {
        try {
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(KEY);
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
            JwtBuilder builder = Jwts.builder()
                    .setSubject(shiroUsers.getUsername())
                    .setIssuedAt(now)
                    .setAudience(shiroUsers.getPassword())
                    .claim(JwtInfoEnum.USER_UUID.getInfoName(), shiroUsers.getUserUuid())
                    .claim(JwtInfoEnum.ROLE.getInfoName(), shiroUsers.getRole())
                    .claim(JwtInfoEnum.PERMISSION.getInfoName(), shiroUsers.getPermissions())
                    .signWith(SignatureAlgorithm.HS512, signingKey);
            long expMillis = nowMillis + EXPIRE_TIME;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
            return tokenHeader + builder.compact();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    /**
     * 验证token是否有效
     *
     * @param token
     * @return
     */
    private static Claims checkToken(String token) {
        try {
            return Jwts.parser().setSigningKey(KEY).parseClaimsJws(
                    token.replace(tokenHeader, "")).getBody();
        } catch (Exception ex) {
            throw new RetailException(RetailExceptionEnum.TOKEN_ERROR);
        }
    }

    /**
     * 从token获取相关信息
     *
     * @param token
     * @param info  username/password
     * @return
     */
    public static String parseJwtInfo(String token, JwtInfoEnum info) {
        String parseInfo = "";
        try {
            Claims claims = checkToken(token);
            switch (info.getInfoName()) {
                case "USERNAME":
                    parseInfo = claims.getSubject();
                    break;
                case "PASSWORD":
                    parseInfo = claims.getAudience();
                    break;
                case "DATE":
                    parseInfo = DateUtil.formatDate(claims.getIssuedAt(), "yyyy-MM-dd hh:mm:ss");
                    break;
                case "USER_UUID":
                    parseInfo = claims.get(JwtInfoEnum.USER_UUID.getInfoName()).toString();
                    break;
            }
        } catch (Exception ex) {
            throw new RetailException(RetailExceptionEnum.TOKEN_ERROR);
        }
        return parseInfo;
    }

    /**
     * 从token解析权限信息
     *
     * @param token
     * @return
     */
    public static List<String> parseJwtRoles(String token) {
        try {
            String[] str = checkToken(token).get(JwtInfoEnum.ROLE.getInfoName()).toString().split(",");
            return new ArrayList<>(Arrays.asList(str));
        } catch (Exception ex) {
            throw new RetailException(RetailExceptionEnum.TOKEN_ERROR);
        }
    }

    /**
     * 从token解析Permission信息
     *
     * @param token
     * @return
     */
    public static List<String> parseJwtPermission(String token) {
        try {
            String[] str = checkToken(token).get(JwtInfoEnum.PERMISSION.getInfoName()).toString().split(",");
            return new ArrayList<>(Arrays.asList(str));
        } catch (Exception ex) {
            throw new RetailException(RetailExceptionEnum.TOKEN_ERROR);
        }
    }
}
