package com.jvwl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  //注明此注解只能是用在方法上
@Retention(RetentionPolicy.RUNTIME)   //注解在运行时才有效
public @interface MyAnnotation {
public String value() default "hello";
}
