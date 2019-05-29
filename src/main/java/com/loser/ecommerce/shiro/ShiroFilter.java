package com.loser.ecommerce.shiro;

import com.loser.ecommerce.exception.RetailException;
import com.loser.ecommerce.exception.RetailExceptionEnum;
import com.loser.ecommerce.jwt.JwtInfoEnum;
import com.loser.ecommerce.jwt.JwtUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class ShiroFilter extends BasicHttpAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(ShiroFilter.class);

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断请求的请求头是否带上 "Token"
        if (!isLoginAttempt(request, response)) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            try {
                executeLogin(request, response);
                return true;
            } catch (Exception e) {
                logger.error(e.getMessage());
//                return ResponseMsg.failed().push(RetailExceptionEnum.TOKEN_ERROR);
                throw new RetailException(RetailExceptionEnum.TOKEN_ERROR);
            }
        } else {
            logger.error(RetailExceptionEnum.TOKEN_MISSING.getMessage());
            throw new RetailException(RetailExceptionEnum.TOKEN_MISSING);
        }
    }


    @Override
    public boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        return token == null;
    }


    /**
     * 执行登陆操作
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Token");
        String username = JwtUtil.parseJwtInfo(token, JwtInfoEnum.USERNAME);
        String password = JwtUtil.parseJwtInfo(token, JwtInfoEnum.PASSWORD);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        try {
            getSubject(request, response).login(usernamePasswordToken);
        } catch (Exception ex) {
            throw new RetailException(RetailExceptionEnum.USER_PASSWORD_ERROR);
        }
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
