package com.example.blog.vo;

import lombok.Data;

/**
 * @Author: chenming
 * @Description:
 * @Date: Create in 18:19 2019/3/24
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;
}