package com.example.demo.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service // Service Annotation은 @Component를 포함하기 때문에, 별도로 적을 필요가 없음
public class ProductService {
    // Repository에게 데이터 관련 상호작용을 요청

    // Spring Data JPA 코드로 변환
    @Autowired
    private SpringDataProductRepository springDataProductRepository;

    // private ProductRepository productRepository;

    // // @Autowired
    // ProductService(ProductRepository productRepository){
    //     this.productRepository = productRepository;
    // }

    public Product findProduct(int id){ 
        // return productRepository.findProduct(id);
        return springDataProductRepository.findById(id).get();

        // Optional<Product> type을 반환 -> get()을 통해 값을 꺼내줌
        // Optional<Product> -> 값이 없을 경우 null을 반환.

    }

    @Transactional // Transactional은 Class, method 둘 다 달 수 있으며, 해당 범위에만 적용됨
    public void saveProduct(Product product) {
        // productRepository.save(product);
        springDataProductRepository.save(product);
    }

    public List<Product> findAllProducts() {
        // return productRepository.findAllProducts();
        return springDataProductRepository.findAll();
    }

    // // public void makeConnection(){
    // //     productRepository.makeConnection();
    // // }
}
