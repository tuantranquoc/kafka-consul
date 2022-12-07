package com.example.tiki.service;

import com.example.tiki.dto.ProductDto;
import com.example.tiki.model.Product;

public interface ProductService {
    Boolean createProduct(ProductDto product);
}
