package com.vv.Interceptor;

import com.vv.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


@Component
public class JwtInterceptor implements HandlerInterceptor {

    /**
     * @Title: 在请求处理之前进行调用（Controller方法调用之前）
     * @Author: vv
     * @Date: 2025/6/27 18:16
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("Jwt Interceptor preHandle");
        // 只拦截Controller方法，静态资源直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //检查有没有允许匿名访问的注解
        if (method.isAnnotationPresent(AllowAnon.class)) {
            AllowAnon allowAnon = method.getAnnotation(AllowAnon.class);
            if (allowAnon.required()) {
                //允许匿名访问（无需权限）
                return true;
            }
        }

        if (method.isAnnotationPresent(AllowRole.class)) {
            String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {

                return false;
            }
            String token = authorizationHeader.substring(7);
            if (!JwtUtil.verifyToken(token)) {
                ResponseErrorMessage(response);
                return false;
            }
            //获取token中的用户权限
            String userRole = JwtUtil.getUserIdAndRole(token).getRole();
            AllowRole allowRole = method.getAnnotation(AllowRole.class);
            System.out.println("开始拦截,当前所需权限为" + allowRole);
            boolean flag = false;
            //如果有此页面可以多用户访问，需要循环遍历role
            for (String allowed : allowRole.value()) {
                if (allowed.equalsIgnoreCase(userRole)) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                ResponseErrorMessage(response);
                return false;
            }
            try {
                //验证token
                if (JwtUtil.verifyToken(token)) {
                    //验证成功
                    return true;
                } else {

                    //验证失败
                    ResponseErrorMessage(response);
                    return false;
                }
            } catch (Exception e) {

                ResponseErrorMessage(response);
                return false;
            }

        }



        return true;
    }



    /**
     * 响应错误消息
     *
     * @param response
     * @throws IOException
     */
    private void ResponseErrorMessage(HttpServletResponse response) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write("{\"success\":false,\"message\":\"无权限\",\"data\":null}");
    }

}