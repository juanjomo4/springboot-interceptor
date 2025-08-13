package com.juanjo.curso.springboot.app.interceptor.springboot_interceptor.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // Interceptor para todos los endpoints
        registry.addInterceptor(timeInterceptor);

        // Interceptor solo para los endpoints /app/bar y /app/foo
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "/app/foo");

        // Interceptor para los endpoints /app/** (todos los endpoints que empiecen por /app/)
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/**);

        // Interceptor para todos los endpoints excepto /app/foo
        // registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/foo");

    }

}
