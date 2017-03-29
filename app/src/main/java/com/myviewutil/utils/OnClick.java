package com.myviewutil.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：ASUS1 on 2017/3/29 09:21
 * <p>
 * 邮箱：1661209460@qq.com
 */
@Target(ElementType.TYPE.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnClick {
    int value();
}
