package com.wht.filter;

import com.wht.domain.User;
import com.wht.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("autoLoginFilter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = request.getRequestURI();
        System.out.println("uri:" + uri);
        String[] paths = {"login", "regist","validate","css","images","js"};//放行路径包含的字符串
        boolean isGo = false;//不放行
        for (String path : paths) {
            if (uri.contains(path)) {
                isGo = true;
            }
        }
        if (isGo) {
            chain.doFilter(request, resp);
            return;
        } else {
            //判断是不登录
            Object obj = request.getSession().getAttribute("user");
            if (obj == null) {
                //没登录
                Cookie[] cookies = request.getCookies();
                User user = null;
                if (cookies != null && cookies.length > 0) {
                    for (Cookie cookie : cookies) {
                        if ("autoLogin".equals(cookie.getName())) {
                            String v = cookie.getValue();
                            user = new User();
                            user.setUserName(v.split("-")[0]);
                            user.setPassword(v.split("-")[1]);
                            break;
                        }
                    }
                }
                //Cookie中存在用户名和密码
                if (user != null) {
                    user = new UserService().login(user);
                    if (user.getId() != null) {
                        request.getSession().setAttribute("user", user);
                        chain.doFilter(request, resp);
                        return;
                    } else {
                        resp.sendRedirect(request.getContextPath() + "/login.jsp");
                    }
                } else {
                    resp.sendRedirect(request.getContextPath() + "/login.jsp");
                }


            } else {
                chain.doFilter(request, resp);
            }
        }
//        Cookie[] cookies= request.getCookies();
//        String autoLogin="";
//        for(int i=0;i<cookies.length;i++){
//            if(cookies[i].getName().equals("autoLogin")){
//                autoLogin=cookies[i].getValue();
//                break;
//            }
//        }
//        if(!autoLogin.equals("")){
//            String[] parts=autoLogin.split("-");
//            String userName=parts[0];
//            String password=parts[1];
//            User user=new User();
//            user.setUserName(userName);
//            user.setPassword(password);
//            request.getSession().setAttribute("user",user);
//        }
//        filterChain.doFilter(request,resp);

    }

    @Override
    public void destroy() {

    }
}
