package com.erosproject.erosdatabase.product.model.mapper;

import com.erosproject.erosdatabase.product.dto.ProductDTO;
import com.erosproject.erosdatabase.product.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);
}
