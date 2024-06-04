package com.example.demo.product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<Product, Integer>{
    // Spring Data JPA를 사용한 Repository (entity명, index)
    List<Product> findByName(String name); // 사용자 정의 함수 생성 가능 (강의에서는 <Generic> 해주는데 왠지 안됨...)
}
