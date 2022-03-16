package com.erosproject.erosdatabase.subcategory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponseDTO {
  private String subcategory_name;

  private String subcategory_desc;

  private Boolean is_active;

  private LocalDate created_at;

  private LocalDate updated_at;
}
