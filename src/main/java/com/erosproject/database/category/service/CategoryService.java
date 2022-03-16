package com.erosproject.database.category.service;

import com.erosproject.database.category.dto.CategoryDTO;
import com.erosproject.database.category.model.mapper.CategoryMapper;
import com.erosproject.database.repository.CategoryRepository;
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
