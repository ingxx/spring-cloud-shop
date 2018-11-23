package top.ingxx.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ingxx.common.enums.ExceptionEnum;
import top.ingxx.common.exception.ShopException;
import top.ingxx.item.pojo.Brand;
import top.ingxx.item.service.BrandService;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/test")
    public ResponseEntity<List<Brand>> test(){
        throw new ShopException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
    }
}
