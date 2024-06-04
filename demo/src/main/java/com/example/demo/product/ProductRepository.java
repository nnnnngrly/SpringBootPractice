package com.example.demo.product;

// import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.datasource.DataSourceUtils;
// import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

// @Repository
public class ProductRepository {
    // DataBase와 소통 

    @Autowired
    DataSource dataSource;

    @Autowired
    EntityManager entityManager; // DB에 CRUD 할 수 있도록 Method를 제공

    // DataSource로 터널 뚫어보기 (=DB와의 커넥션 생성)
    // public void makeConnection () {
    //     DataSourceUtils.getConnection(dataSource);
    // }
    
    // 아직 DB와 연동할 수 없기 때문에 임시로 Map을 만들어서 DB처럼 사용
    // Java의 Map은 Key-vale pair의 자료구조 (python Dict, js Object)
    private Map<Integer, Product> db = new HashMap<>();
    private int id = 1;

    public Product findProduct(int idx){
        return db.get(idx);
    }

    // public void save(Product product) {
    //     db.put(id++, product);
    //     // System.out.println(product.getName());
    // }

    // public List<Product> findAllProducts() {
    //     return new ArrayList<>(db.values());
    // }

    // 이제 실제 DB를 사용하여 연동
    public List<Product> findAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public void save(Product product) {
        entityManager.persist(product);
    }
}