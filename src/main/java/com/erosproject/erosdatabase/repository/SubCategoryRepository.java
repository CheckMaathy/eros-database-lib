package com.erosproject.erosdatabase.repository;

import com.erosproject.erosdatabase.subcategory.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    SubCategory findByName(String name);
}
