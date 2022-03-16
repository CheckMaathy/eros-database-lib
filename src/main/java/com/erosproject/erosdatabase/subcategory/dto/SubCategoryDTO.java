package com.erosproject.erosdatabase.subcategory.dto;

import com.erosproject.erosdatabase.subcategory.model.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDTO {
  private Integer subCategoryId;
  private Integer categoryId;
  private String subCategoryName;
  private Boolean isActive;
  private LocalDate createdAt;
  private LocalDate updatedAt;
}
