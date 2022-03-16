package com.erosproject.erosdatabase.category.model.mapper;

import com.erosproject.erosdatabase.category.dto.CategoryDTO;
import com.erosproject.erosdatabase.category.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);
}
