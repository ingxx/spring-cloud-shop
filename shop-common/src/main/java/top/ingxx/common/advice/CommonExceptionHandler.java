package top.ingxx.common.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import top.ingxx.common.exception.ShopException;
import top.ingxx.common.vo.ExceptionResult;

/**
 * 定义自定义拦截器 拦截运行时错误
 */
@ControllerAdvice
public class CommonExceptionHandler {
    //捕获自定义类型的异常
    /**
     * 接受一个异常对象
     */
    @ExceptionHandler(ShopException.class)
    public ResponseEntity<ExceptionResult> handException(ShopException em){
        return ResponseEntity.status(em.getExceptionEnum().getCode()).body(new ExceptionResult(em.getExceptionEnum()));
    }
}
