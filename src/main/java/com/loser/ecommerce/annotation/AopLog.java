package com.loser.ecommerce.annotation;

import java.lang.annotation.*;

/**
 *Aop注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopLog {
}
