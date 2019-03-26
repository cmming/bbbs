package com.example.blog.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: chenming
 * @Description:
 * @Date: Create in 15:45 2019/3/24
 */

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

//    product_id` varchar(32) not null,
//            `product_name` varchar(64) not null comment '商品名称',
//            `product_price` decimal(8,2) not null comment '单价',
//            `product_stock` int not null comment '库存',
//            `product_description` varchar(64) comment '描述',
//            `product_icon` varchar(512) comment '小图',
//            `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
//            `category_type` int not null comment '类目编号',
//            `create_time` timestamp not null default current_timestamp comment '创建时间',
//            `update_time` timestamp not null default c
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}
