package com.wht.controller;

import com.wht.domain.User;
import com.wht.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class RegisterController extends HttpServlet {
    UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取所有的用户信息
        User user=new User();
        user.setPassword(request.getParameter("password"));
        user.setUserName(request.getParameter("username"));
        user.setTelephone(request.getParameter("phone"));
        user.setIntroduce(request.getParameter("introduce"));
        user.setGender(request.getParameter("gender"));
        user.setEmail(request.getParameter("email"));
        //激活码

        user.setActiveCode(UUID.randomUUID().toString());
        boolean result= userService.register(user);
        if(result){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
            response.getWriter().println("注册失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
