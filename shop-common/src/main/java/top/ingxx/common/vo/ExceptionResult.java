package top.ingxx.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.ingxx.common.enums.ExceptionEnum;

/**
 * 返回给前端的异常对象
 */
@ToString
@Getter
@Setter
public class ExceptionResult{

    private int status;  //状态码
    private String message; //错误信息
    private long timestamp;  //时间戳

    public ExceptionResult(ExceptionEnum em){
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
