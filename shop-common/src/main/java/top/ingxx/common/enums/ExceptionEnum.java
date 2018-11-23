package top.ingxx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 错误信息枚举
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    UNKONW_ERROR(-1, "未知错误"),
    PRICE_CANNOT_BE_NULL(400,"价格不能为空!"),
    ;
    private Integer code;  //状态码
    private String msg;    //错误信息

}