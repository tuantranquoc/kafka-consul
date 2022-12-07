package com.example.tiki.service.impl;

import com.example.tiki.dto.ProductDto;
import com.example.tiki.model.Product;
import com.example.tiki.repository.ProductRepository;
import com.example.tiki.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

//    private final ProductRepository productRepository;
//
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Autowired
    ProductRepository productRepository;

    @Override
    public Boolean createProduct(ProductDto productDto) {
        try{
            BigDecimal price = new BigDecimal(productDto.getPrice());
            Product product = Product.builder().name(productDto.getName()).price(price).build();
            productRepository.save(product);
            return true;
        }catch (NumberFormatException exception){
            return false;
        }


    }
}
