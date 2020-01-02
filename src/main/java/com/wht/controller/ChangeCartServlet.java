package com.wht.controller;

import com.wht.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ChangeCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        int count=Integer.parseInt(req.getParameter("count"));
        HttpSession session=req.getSession();
        Map<Product,Integer> cart=(Map<Product,Integer>)session.getAttribute("cart");
        Product p=new Product();
        p.setId(id);
        if(count!=0){
            cart.put(p,count);
        }else{
            cart.remove(p);
        }
        resp.sendRedirect(req.getContextPath()+"/cart.jsp");
    }
}
