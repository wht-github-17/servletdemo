package com.wht.controller;

import com.wht.domain.User;
import com.wht.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        


        String userName=req.getParameter("username");
        //System.out.println(userName);
        String password=req.getParameter("password");
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        User u=userService.login(user);
//登录成功
        if(u!=null){
            req.getSession().setAttribute("user",u);

            //记住用户名
            String remeber=req.getParameter("remeber");
            if("1".equals(remeber)){
                Cookie cookie=new Cookie("remeber",userName+"-"+password);
                cookie.setMaxAge(60*60);
                cookie.setPath("/");
                System.out.println(cookie.getPath());
                resp.addCookie(cookie);
            }
            //自动登录选中
            String autoLogin=req.getParameter("autoLogin");
            if("1".equals(autoLogin)){
                Cookie cookie=new Cookie("autoLogin",userName+"-"+password);
                cookie.setMaxAge(24*60*60);
                resp.addCookie(cookie);
            }
            req.getRequestDispatcher("notice").forward(req,resp);
        }else{
            resp.sendRedirect(resp.encodeRedirectURL("login.jsp"));
        }
    }
}
