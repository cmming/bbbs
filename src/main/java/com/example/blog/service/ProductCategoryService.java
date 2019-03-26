package com.example.blog.service;

import com.example.blog.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author: chenming
 * @Description:
 * @Date: Create in 15:24 2019/3/24
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
