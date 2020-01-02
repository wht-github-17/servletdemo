package com.wht.controller;

import com.wht.domain.Product;
import com.wht.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddCartController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");

        ProductService productService=new ProductService();
        Product product=productService.findById(id);
        System.out.println(product);
        HttpSession session=req.getSession();
        Map<Product,Integer> cart=(Map<Product,Integer>)session.getAttribute("cart");
        if(cart==null){
            cart=new HashMap<>();
        }
        Integer count=cart.put(product,1);
        if(count!=null){
            cart.put(product,count+1);
        }
        session.setAttribute("cart",cart);
        resp.sendRedirect(req.getContextPath()+"/cart.jsp");

    }
}
