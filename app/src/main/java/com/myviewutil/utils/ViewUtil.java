package com.myviewutil.utils;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：ASUS1 on 2017/3/29 09:25
 * <p>
 * 邮箱：1661209460@qq.com
 */
public class ViewUtil {
    public void ViewInject(Activity activity) throws IllegalAccessException {
        bindView(activity);
        onClickView(activity);
    }

    
    //绑定控件
    public void bindView(Activity activity) throws IllegalAccessException {
        Class clazz = activity.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();//拿到所有的成员变量
        for(int i = 0;i < declaredFields.length;i ++){
            Field declaredField = declaredFields[i];
            BindView annotation = declaredField.getAnnotation(BindView.class);
            //找到要绑定的对象
            if (annotation != null){
                int resId = annotation.value();
                View viewById = activity.findViewById(resId);
                declaredField.setAccessible(true);
                declaredField.set(activity,viewById);
            }
        }

    }
    
    
    //绑定点击事件
    public void onClickView(final Activity activity) {
        Class clazz = activity.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i = 0;i < declaredMethods.length;i ++){
            final Method declaredMethod = declaredMethods[i];
            OnClick annotation = declaredMethod.getAnnotation(OnClick.class);
            if (annotation != null){
                int resId = annotation.value();
                declaredMethod.setAccessible(true);
                final View viewById = activity.findViewById(resId);
                viewById.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {
                            declaredMethod.invoke(activity,viewById);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        }

    }
}
