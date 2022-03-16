package com.erosproject.erosdatabase.config;

import com.erosproject.erosdatabase.category.service.CategoryService;
import com.erosproject.erosdatabase.product.service.ProductService;
import com.erosproject.erosdatabase.subcategory.service.SubCategoryService;
import com.erosproject.erosdatabase.user.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Configuration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({ DatabaseConfig.class, CategoryService.class, UserService.class,
        SubCategoryService.class, ProductService.class })
public @interface EnableErosDatabaseLibrary {
}
