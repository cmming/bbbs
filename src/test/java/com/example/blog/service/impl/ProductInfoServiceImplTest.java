package com.example.blog.service.impl;

import com.example.blog.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;


    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123456");

        System.out.println(productInfo.toString());
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void finndUpAll() {
        List<ProductInfo> productInfo = productInfoService.findUpAll();

        System.out.println(productInfo.toString());
        Assert.assertNotEquals(0,productInfo.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page result =  productInfoService.findAll(request);
        System.out.println(result.getTotalElements());

    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234567");
        productInfo.setProductName("皮蛋粥123");
        productInfo.setProductPrice(new BigDecimal(3.22));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好好喝");
        productInfo.setProductIcon("https://12312312312");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        productInfoService.save(productInfo);
    }
}