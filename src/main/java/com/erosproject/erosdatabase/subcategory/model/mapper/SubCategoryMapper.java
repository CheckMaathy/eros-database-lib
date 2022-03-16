package com.erosproject.erosdatabase.subcategory.model.mapper;


import com.erosproject.erosdatabase.subcategory.dto.SubCategoryDTO;
import com.erosproject.erosdatabase.subcategory.model.SubCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

    SubCategoryDTO toDTO(SubCategory subCategory);
}
