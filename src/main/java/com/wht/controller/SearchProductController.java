package com.wht.controller;

import com.wht.domain.Product;
import com.wht.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchProductController extends HttpServlet {
    ProductService productService=new ProductService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        List<Product> productList=productService.findByName(name);
        if(productList!=null &&productList.size()>0){
            req.setAttribute("products",productList);
            req.getRequestDispatcher("detail.jsp").forward(req,resp);
        }else{


        }
    }
}
