package top.ingxx.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ingxx.item.pojo.Brand;
import top.ingxx.item.service.BrandService;

import java.util.List;

/// TODO: 2018/11/23  这里使用CORS暂时解决跨域问题 明天使用zuul和nginx解决
@CrossOrigin
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @CrossOrigin
    @GetMapping("/findAll")
    public ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(brandService.selectAll());
    }
}
