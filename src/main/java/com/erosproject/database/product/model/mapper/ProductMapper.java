package com.erosproject.database.product.model.mapper;

import com.erosproject.database.product.dto.ProductDTO;
import com.erosproject.database.product.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);
}
