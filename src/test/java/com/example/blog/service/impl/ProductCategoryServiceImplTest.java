package com.example.blog.service.impl;

import com.example.blog.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;


    @Test
    public void findOne() {
        ProductCategory data =  productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1),data.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> result = productCategoryService.findAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,2);
        List<ProductCategory> result = productCategoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void save() {
        ProductCategory data = new ProductCategory("测试",101);
        ProductCategory result = productCategoryService.save(data);
        Assert.assertNotEquals(null,result);
    }
}