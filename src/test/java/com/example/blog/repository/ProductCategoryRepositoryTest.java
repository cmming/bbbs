package com.example.blog.repository;

import com.example.blog.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){

        ProductCategory productCategory = productCategoryRepository.findById(1).get();
        System.out.println(productCategory.toString());
    }


    @Test
    public void store(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱1");
        productCategory.setCategoryType(2);
        productCategoryRepository.save(productCategory);
    }

    @Test
//    @Transactional
    public void update(){
        ProductCategory productCategory = productCategoryRepository.findById(2).get();
        productCategory.setCategoryName("男生最爱3");
        productCategory.setCategoryType(10);

        ProductCategory objProductCategory = new ProductCategory("chenming",100);
        productCategoryRepository.save(objProductCategory);
    }

    @Test
    public void delete(){
        productCategoryRepository.deleteById(100);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,10);
        List<ProductCategory> result =productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
        System.out.println(result.toString());
        System.out.println(result.size());
    }


    @Test
    public void findByCategoryIdIn(){
        List<Integer> list = Arrays.asList(1,10);
        List<ProductCategory> result =productCategoryRepository.findByCategoryIdIn(list);
        Assert.assertNotEquals(0,result.size());
        System.out.println(result.toString());
        System.out.println(result.size());
    }



}