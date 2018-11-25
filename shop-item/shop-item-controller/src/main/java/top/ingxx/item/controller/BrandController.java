package top.ingxx.item.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.ingxx.common.vo.PageVo;
import top.ingxx.common.vo.Result;
import top.ingxx.item.pojo.Brand;
import top.ingxx.item.service.BrandService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(brandService.selectAll());
    }

    @GetMapping("/findPage")
    public ResponseEntity<PageVo> findPage(int page, int size) {
        PageVo pageVo = brandService.findPage(page, size);
        return ResponseEntity.ok(pageVo);
    }

    /***
     * jQuery传输数据使用了Content-Type: x-www-form-urlencodedand
     * AngularJS传输数据使用了Content-Type: application/json
     * @param brand
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Brand brand){
        Result result = brandService.add(brand);
        return ResponseEntity.ok(result);
    }
}
