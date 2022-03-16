package com.erosproject.database.subcategory.model.mapper;


import com.erosproject.database.subcategory.dto.SubCategoryDTO;
import com.erosproject.database.subcategory.model.SubCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

    SubCategoryDTO toDTO(SubCategory subCategory);
}
