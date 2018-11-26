package top.ingxx.common.vo;

import lombok.Data;

@Data
public class Result<T> {
    private int status;
    private String message;
    private T data;

    public static <T> Result<T> success(T data){
        return new Result<>(200,"成功",data);
    }

    public static <T> Result<T> error(int status,String message){
        return new Result<>(status,message,null);
    }

    public Result(T data){
        this.data = data;
    }
    public Result(int status,String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
