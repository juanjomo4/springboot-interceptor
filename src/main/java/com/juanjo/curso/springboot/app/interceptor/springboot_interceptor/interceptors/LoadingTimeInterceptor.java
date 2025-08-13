package com.juanjo.curso.springboot.app.interceptor.springboot_interceptor.interceptors;

// import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("LoadingTimeInterceptor: preHandle() entrando..." + handlerMethod.getMethod().getName());
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        // Simula un tiempo de carga aleatorio
        // Random random = new Random();
        // int delay = random.nextInt(500);
        // Thread.sleep(delay);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

        // Estas variables se usan para calcular el tiempo de carga en milisegundos
        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");
        long loadingTime = endTime - startTime;
        logger.info("Tiempo de carga: " + loadingTime + " ms");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("LoadingTimeInterceptor: postHandle() saliendo..." + handlerMethod.getMethod().getName());
    }

}
