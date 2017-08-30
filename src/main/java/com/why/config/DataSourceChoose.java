package com.why.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class DataSourceChoose {

    /**
     * 方法执行前
     */
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        String method = joinPoint.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Class<?>[] parameterTypes = methodSignature.getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m!=null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                JdbcContextHolder.clearJdbcType();
                JdbcContextHolder.setJdbcType(data.value().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
