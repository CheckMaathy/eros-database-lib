package com.erosproject.database.product.service;

import com.erosproject.database.product.dto.ProductDTO;
import com.erosproject.database.product.model.mapper.ProductMapper;
import com.erosproject.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Cacheable(cacheNames = "productCache", key = "{#root.methodName, #productCode}", cacheManager = "redisCacheManager")
    public ProductDTO findProductByName(String name) {
        return productMapper.toDTO(productRepository.findByName(name));
    }
}
