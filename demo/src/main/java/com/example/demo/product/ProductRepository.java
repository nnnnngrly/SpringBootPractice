package com.example.demo.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

// @Repository
public class ProductRepository {
    // DataBase와 소통
    
    // 아직 DB와 연동할 수 없기 때문에 임시로 Map을 만들어서 DB처럼 사용
    // Java의 Map은 Key-vale pair의 자료구조 (python Dict, js Object)
    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public Product findProduct(int idx){
        return db.get(idx);
    }

    public void save(Product product) {
        db.put(id++, product);
        // System.out.println(product.getName());
    }

    public List<Product> findAllProducts() {
        return new ArrayList<>(db.values());
    }
}
