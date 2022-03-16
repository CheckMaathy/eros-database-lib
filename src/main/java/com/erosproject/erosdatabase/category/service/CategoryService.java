package com.erosproject.erosdatabase.category.service;

import com.erosproject.erosdatabase.category.dto.CategoryDTO;
import com.erosproject.erosdatabase.category.model.mapper.CategoryMapper;
import com.erosproject.erosdatabase.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Cacheable(cacheNames = "categoryCache", key = "{#root.methodName, #categoryCode}", cacheManager = "redisCacheManager")
    public CategoryDTO findCategoryByName(String name) {
        return categoryMapper.toDTO(categoryRepository.findByName(name));
    }
}
