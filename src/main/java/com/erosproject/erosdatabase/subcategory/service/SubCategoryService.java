package com.erosproject.erosdatabase.subcategory.service;

import com.erosproject.erosdatabase.repository.SubCategoryRepository;
import com.erosproject.erosdatabase.subcategory.dto.SubCategoryDTO;
import com.erosproject.erosdatabase.subcategory.model.mapper.SubCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    private SubCategoryRepository subCategoryRepository;
    private SubCategoryMapper subCategoryMapper;

    @Autowired
    public SubCategoryService(SubCategoryRepository subCategoryRepository, SubCategoryMapper subCategoryMapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.subCategoryMapper = subCategoryMapper;
    }

    @Cacheable(cacheNames = "subCategoryCache", key = "{#root.methodName, #subCategoryCode}", cacheManager = "redisCacheManager")
    public SubCategoryDTO findSubCategoryByName(String name) {
        return subCategoryMapper.toDTO(subCategoryRepository.findByName(name));
    }

}
