package com.rodrigopeleias.myspringcontacts.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String controllerName = "";
        String actionName = "";

        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            controllerName = handlerMethod.getBeanType().getSimpleName().replace("Controller", "");
            actionName = handlerMethod.getMethod().getName();
        }

        modelAndView.addObject("controllerName", controllerName);
        modelAndView.addObject("actionName", actionName);
    }
}
