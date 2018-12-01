package top.ingxx.item.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import top.ingxx.item.pojo.TbBrand;

import java.util.List;

/***
 * 声明接口，其他服务可以直接引用此模块
 */
@FeignClient(name = "item-service")
public interface ItemInterface {
    @GetMapping("/findAll")
    List<TbBrand> findAll();
}
