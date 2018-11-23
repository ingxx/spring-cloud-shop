package top.ingxx.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import top.ingxx.common.enums.ExceptionEnum;

/***
 * 自定义自己的运行异常，继承运行异常
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShopException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
