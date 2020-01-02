package com.wht.controller;

import com.wht.domain.User;
import com.wht.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUsersController extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users=userService.getAll();
        req.setAttribute("users",users);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }
}
