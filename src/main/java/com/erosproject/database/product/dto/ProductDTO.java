package com.erosproject.database.product.dto;

import com.erosproject.database.enums.SizeEnum;
import com.erosproject.database.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String productName;
    private String description;
    private Category category;
    private SizeEnum size;
    private BigDecimal value;
    private Boolean isActive;

}
