package com.myviewutil.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：ASUS1 on 2017/3/29 09:19
 * <p>
 * 邮箱：1661209460@qq.com
 */
@Target(ElementType.TYPE.FIELD)//该注解的作用对象为成员变量
@Retention(RetentionPolicy.RUNTIME)//该注解的生命周期为运行时
public @interface BindView {
    int value();
}
