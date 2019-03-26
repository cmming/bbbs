package form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @Author: chenming
 * @Description:
 * @Date: Create in 22:21 2019/3/26
 */
@Data
public class ProductInfoForm {

    private String productId;

    /** 名字. */
    @NotEmpty(message = "产品名称必填")
    private String productName;

    /** 单价. */
//    @NotEmpty(message = "单价必填")
    private BigDecimal productPrice;

    /** 库存. */
//    @NotEmpty(message = "库存必填")
    private Integer productStock;

    /** 描述. */
    @NotEmpty(message = "描述必填")
    private String productDescription;

    /** 小图. */
    @NotEmpty(message = "图片必传")
    private String productIcon;

    /** 类目编号. */
//    @NotEmpty(message = "产品类型必须选择")
    private Integer categoryType;
}
