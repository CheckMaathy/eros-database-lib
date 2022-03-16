package com.erosproject.database.category.model.mapper;

import com.erosproject.database.category.dto.CategoryDTO;
import com.erosproject.database.category.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);
}
