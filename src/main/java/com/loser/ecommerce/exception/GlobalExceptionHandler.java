package com.loser.ecommerce.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseControllerExceptionHandler {
//    @ExceptionHandler(JwtException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorMsg jwtException(JwtException e) {
//        return new ErrorMsg(RetailExceptionEnum.TOKEN_ERROR.getCode(),RetailExceptionEnum.TOKEN_ERROR.getMessage());
//    }
}
