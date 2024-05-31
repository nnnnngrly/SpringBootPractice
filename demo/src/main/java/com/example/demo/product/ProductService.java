package com.example.demo.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Service Annotation은 @Component를 포함하기 때문에, 별도로 적을 필요가 없음
public class ProductService {
    // Repository에게 데이터 관련 상호작용을 요청

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findProduct(int id){ 
        return productRepository.findProduct(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    public void makeConnection(){
        productRepository.makeConnection();
    }
}
