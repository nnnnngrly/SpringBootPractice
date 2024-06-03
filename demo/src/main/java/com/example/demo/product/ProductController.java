package com.example.demo.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;



// @Controller // @Controller도 사실 @Component를 포함하고 있음
// @ResponseBody // 데이터를 Response Body라는 틀에 담아 넣어줘야 하는데, 이게 없으면 데이터를 그냥 반환함 -> API 형식이라는 걸 알려주는 Annotation
@RestController // @Controller + @ResponseBody
public class ProductController {
    // 사용자(화면)에서 요청을 던지면, 그에 맞는 로직을 수행할 수 있도록 Service에게 요청
    
    @Autowired // 등록된 빈을 사용하기 위한 Annotation
    private ProductService productService;

    // 전체 상품 조회 Method
    @GetMapping("products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    // 개별 상품을 조회하는 Method
    // value : endpoint, method : 요청 메소드
    // @RequestMapping(value = "products/{id}", method = RequestMethod.GET)
    @GetMapping("products/{id}") // @RequestMapping(method=GET}) 대체
    public Product findProduct(@PathVariable("id") int id) { // @pathVariable 쓰려면 @RequestMapping의 value도 수정해야 함
        // ProductService productService = new ProductService();
        return productService.findProduct(id);
    }

    // // 상품 등록
    // @RequestMapping(value = "products", method = RequestMethod.POST)
    // public void saveProduct(@RequestParam(value="name") String productName) {
    //     //localhost:8080/products?name="XX"의 XX를 productName이라는 변수로 보내준다.
    //     productService.saveProduct(productName);
    // }    

    // 상품 등록
    // @RequestMapping(value = "products", method=RequestMethod.POST)
    @PostMapping("products") // @RequestMapping(method="Post") 대체
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    // @GetMapping("connect")
    // public void makeConnection() {
    //     productService.makeConnection();
    // }
    
}
