package com.jvwl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  //ע����ע��ֻ�������ڷ�����
@Retention(RetentionPolicy.RUNTIME)   //ע��������ʱ����Ч
public @interface MyAnnotation {
public String value() default "hello";
}
