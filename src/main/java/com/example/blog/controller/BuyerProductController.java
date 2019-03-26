package com.example.blog.controller;

import com.example.blog.dataobject.ProductCategory;
import com.example.blog.dataobject.ProductInfo;
import com.example.blog.service.ProductCategoryService;
import com.example.blog.service.ProductInfoService;
import com.example.blog.utils.ResultVOUtil;
import com.example.blog.vo.ProductInfoVO;
import com.example.blog.vo.ProductVO;
import com.example.blog.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: chenming
 * @Description:
 * @Date: Create in 18:17 2019/3/24
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //获取所有上线的产品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2。查询类目
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo  productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
//        (lambda)

//        List<Integer> categoryTypeList = productInfoList.stream()
//                .map(e -> e.getCategoryType())
//                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);



        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

//        System.out.println(productInfoList);
//        ResultVO resultVO = new ResultVO();
////        ProductVO productVO = new ProductVO();
////        ProductInfoVO productInfoVO = new ProductInfoVO();
////
////        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
////        resultVO.setData(Arrays.asList(productVO));
//
//        resultVO.setData(Arrays.asList(productVOList));
//        resultVO.setCode(0);
//        resultVO.setMessage("成功");
        return ResultVOUtil.success(productVOList);
//        return resultVO;
    }
}
