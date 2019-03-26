package com.example.blog.repository;

import com.example.blog.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void store(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.22));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好好喝");
        productInfo.setProductIcon("https://12312312312");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        ProductInfo result = productInfoRepository.save(productInfo);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus(){
        List<Integer> list = Arrays.asList(0);
        List<ProductInfo> result = productInfoRepository.findByProductStatus(0);

        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void update(){

    }

    @Test
    public void findOne(){

    }

    @Test
    public void delete(){

    }
}