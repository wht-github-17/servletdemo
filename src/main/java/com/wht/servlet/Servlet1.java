package com.wht.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1 extends HttpServlet {
    public Servlet1(){
        System.out.println("constructor");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
            }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        System.out.println("servlet1:service");
        //resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
       // req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        System.out.println(name);
        //out.println("服务");
        name=new String(name.getBytes("iso-8859-1"),"utf-8");
        System.out.println(name);
        String password=req.getParameter("password");
        System.out.println(password);
        String sex=req.getParameter("sex");
        System.out.println(sex);
        String[] hobby=req.getParameterValues("hobby");
        for(String h:hobby){
            System.out.println(h);
        }
        String h1=req.getParameter("h1");
        System.out.println(h1);
        String classId=req.getParameter("classId");
        System.out.println(classId);
        String comment=req.getParameter("comment");
        System.out.println(comment);
     //  req.getRequestDispatcher("/a.html").forward(req,resp);
        resp.sendRedirect("/servletdemo_war/a.html");

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
