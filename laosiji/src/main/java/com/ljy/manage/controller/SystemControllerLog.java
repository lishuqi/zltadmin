package com.ljy.manage.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解：拦截controller
 * 
 * 在使用AOP做日志的时候需要切面只想controller层，因为controller是被jdk管理的
 * 所以需要自定义注解使controller被cglib所管理
 * 
 * @author LSQ
 * by QQ237442461 2016-10-6
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented 
public @interface SystemControllerLog {

	String description()  default "";    
}
