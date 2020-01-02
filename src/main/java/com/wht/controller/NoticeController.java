package com.wht.controller;

import com.wht.domain.Notice;
import com.wht.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NoticeController extends HttpServlet {
    NoticeService noticeService=new NoticeService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Notice> notices=noticeService.getNotice();
        req.setAttribute("notices",notices);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
