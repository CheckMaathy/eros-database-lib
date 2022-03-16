package com.erosproject.database.config;

import com.erosproject.database.category.model.mapper.CategoryMapper;
import com.erosproject.database.category.service.CategoryService;
import com.erosproject.database.product.model.mapper.ProductMapper;
import com.erosproject.database.product.service.ProductService;
import com.erosproject.database.subcategory.model.mapper.SubCategoryMapper;
import com.erosproject.database.subcategory.service.SubCategoryService;
import com.erosproject.database.user.model.mapper.UserMapper;
import com.erosproject.database.user.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Configuration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({ DatabaseConfig.class, CategoryService.class, UserService.class,
        SubCategoryService.class, ProductService.class, CategoryMapper.class,
        ProductMapper.class, SubCategoryMapper.class, UserMapper.class })
public @interface EnableErosDatabaseLibrary {
}
