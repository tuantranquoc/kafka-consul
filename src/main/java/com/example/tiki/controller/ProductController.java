package com.example.tiki.controller;

import com.example.tiki.dto.ProductDto;
//import com.example.tiki.kafka.KafkaProductSender;
import com.example.tiki.kafka.KafkaProductSender;
import com.example.tiki.property.AppProperties;
import com.example.tiki.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class ProductController {


    @Autowired
    AppProperties appProperty;

    private final ProductService productService;

    private final KafkaProductSender kafkaProductSender;

    public ProductController(ProductService productService, KafkaProductSender kafkaProductSender) {
        this.productService = productService;
        this.kafkaProductSender = kafkaProductSender;
    }

    @GetMapping("/consul")
    public String checkConsul(){
        log.info("value username: {}", appProperty.getUsername());
        return appProperty.getUsername();
    }

    @GetMapping("/notification")
    public Boolean tikiNotificationNewProduct() {
        kafkaProductSender.sendMessage("Hello World");
        return true;
    }

    @PostMapping("/create")
    public Boolean createProduct(@RequestBody ProductDto productDto) {
//        kafkaProductSender.sendMessage("Hello World");
        return productService.createProduct(productDto);
    }
}
