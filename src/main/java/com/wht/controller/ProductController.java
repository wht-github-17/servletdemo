package com.wht.controller;

import com.wht.domain.Product;
import com.wht.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductController extends HttpServlet {
    ProductService productService=new ProductService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String path=req.getRequestURI();
      // System.out.println(path);
       String action=path.substring(path.lastIndexOf("/")+1,path.indexOf("."));
       //System.out.println(action);
        if("search".equals(action)){
            String name=req.getParameter("name");
            List<Product> productList=productService.findByName(name);
            if(productList!=null  && productList.size()>0){
                req.setAttribute("products",productList);
                req.getRequestDispatcher("product_search_list.jsp").forward(req,resp);
            }else{
                resp.getWriter().println("没找到");
            }

        }else if("searchById".equals(action)){
            String id=req.getParameter("id");
            Product product=productService.findById(id);
            if(product!=null){
                req.setAttribute("product",product);
                req.getRequestDispatcher("detail.jsp").forward(req,resp);
            }else{

            }

        }
    }
}
