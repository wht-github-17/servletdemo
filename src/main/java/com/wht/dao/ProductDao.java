package com.wht.dao;

import com.wht.domain.Product;
import com.wht.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductDao {
    public List<Product> getByName(String name) {
        List<Product> products = null;
        String sql = "select * from products where name like ?";
        Object[] params = {"%" + name + "%"};
        List<Map<String, Object>> list = DBUtil.executeQuery(sql, params);
        products = select(list);
        return products;

    }

    public Product getById(String id) {
        String sql = "select * from products where id=?";
        Object[] para = {id};
        List<Map<String, Object>> list = DBUtil.executeQuery(sql, para);
        return select(list).get(0);
    }

    private List<Product> select(List<Map<String, Object>> list) {
        List<Product> products = null;
        if (list != null && list.size() > 0) {
            products = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                Product product = new Product();
//处理空值问题，如果值为空，赋个默认值。
                product.setCategory(Optional.ofNullable(map.get("category")).orElse("").toString());


                product.setDescription(Optional.ofNullable(map.get("description")).orElse("").toString());
                product.setId(map.get("id").toString());

                product.setImgurl(Optional.ofNullable(map.get("imgurl")).orElse("").toString());

                product.setName(Optional.ofNullable(map.get("name")).orElse("").toString());

                product.setPnum(Integer.parseInt(Optional.ofNullable(map.get("pnum")).orElse(0).toString()));


                product.setPrice(Double.parseDouble(Optional.ofNullable(map.get("price")).orElse(0.0).toString()));


                products.add(product);
            }
        }
        return products;
    }

}
