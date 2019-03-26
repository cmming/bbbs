package com.example.blog.controller;

import com.example.blog.utils.ResultVOUtil;
import com.example.blog.vo.ResultVO;
import form.ProductInfoForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Author: chenming
 * @Description:
 * @Date: Create in 22:25 2019/3/26
 */

@RestController
@RequestMapping("/seller/product/")
public class SellerProductController {

    @GetMapping("save")
    public ResultVO store(@Valid ProductInfoForm form, BindingResult bindingResult, Map<String, Object> map){

//        if (bindingResult.hasErrors()) {
//            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
//            map.put("url", "/sell/seller/product/index");
//            return ResultVOUtil.error(1,"错误");
//        }
        //
        return ResultVOUtil.success();
    }

}
