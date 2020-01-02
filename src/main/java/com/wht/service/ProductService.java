package com.wht.service;

import com.wht.dao.ProductDao;
import com.wht.domain.Product;

import java.util.List;

public class ProductService {
    ProductDao productDao=new ProductDao();
    public List<Product> findByName(String name) {
        return productDao.getByName(name);
    }
    public Product findById(String id){
        return productDao.getById(id);
    }
}
