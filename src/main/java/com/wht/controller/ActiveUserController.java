package com.wht.controller;

import com.wht.domain.User;
import com.wht.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActiveUserController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String activeCode = req.getParameter("activeCode");
        //System.out.println(activeCode);
        User user = userService.getUser(activeCode);
        if (user != null) {
            //修改用户状态为1
            if (userService.activeUser(user.getId())) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            } else {
                resp.getWriter().println("激活失败");
            }
        } else {
            resp.getWriter().println("没有用户");
        }


    }
}
