package com.erosproject.erosdatabase.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {
  private CategoryDTO CategoryDetails;
  private Integer categoryId;
  private LocalDate createdAt;
}
