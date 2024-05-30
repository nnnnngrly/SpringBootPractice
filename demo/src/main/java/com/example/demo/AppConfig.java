package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.product.ProductRepository;

@Configuration
public class AppConfig {

    @Bean // 아래 메소드가 반환하는 객체를 Spring Bean으로 등록
    public ProductRepository productRepository(){
        return new ProductRepository();
    }
}
