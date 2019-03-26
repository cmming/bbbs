package com.example.blog.repository;

import com.example.blog.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    List<ProductCategory> findByCategoryIdIn(List<Integer> categoryIdList);
}
