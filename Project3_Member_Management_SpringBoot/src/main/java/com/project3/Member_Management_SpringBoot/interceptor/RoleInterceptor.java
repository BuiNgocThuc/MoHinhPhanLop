/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project3.Member_Management_SpringBoot.interceptor;

import com.project3.Member_Management_SpringBoot.annotation.RestrictTo;
import com.project3.Member_Management_SpringBoot.model.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */
public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RestrictTo restrictToAnnotation = handlerMethod.getMethodAnnotation(RestrictTo.class);

            if (restrictToAnnotation != null) {
                String role = getRoleForUser(request);
                if (role == null || !containsRole(restrictToAnnotation.value(), role)) {
                    // Redirect to login page if user is not authenticated or does not have the required role
                    response.sendRedirect("/login");
                    return false;
                }
            }
        }
        return true;
    }

    private String getRoleForUser(HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute("user");
        if (member != null) {
            if (member.getId() == 123456) {
                return "admin";
            } else {
                return "user";
            }
        }
        return null;
    }

    private boolean containsRole(String[] roles, String role) {
        for (String r : roles) {
            if (r.equals(role)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // This method is called after the handler is executed
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        // This method is called after the request is completed
    }
}
