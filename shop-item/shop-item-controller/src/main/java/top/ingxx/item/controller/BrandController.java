package top.ingxx.item.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.ingxx.common.vo.PageVo;
import top.ingxx.common.vo.Result;
import top.ingxx.item.pojo.TbBrand;
import top.ingxx.item.service.BrandService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
    public ResponseEntity<Result<List<TbBrand>>> findAll() {
        return ResponseEntity.ok(brandService.selectAll());
    }

    @GetMapping("/findPage")
    public ResponseEntity<Result<PageVo>> findPage(int page, int size) {
        Result<PageVo> pageVo = brandService.findPage(page, size);
        return ResponseEntity.ok(pageVo);
    }

    /***
     * 新增品牌
     * jQuery传输数据使用了Content-Type: x-www-form-urlencodedand
     * AngularJS传输数据使用了Content-Type: application/json
     * @param tbBrand 商品实体
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Result<String>> add(@RequestBody TbBrand tbBrand) {
        Result<String> result = brandService.add(tbBrand);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Result<TbBrand>> findById(@PathVariable(value = "id") Long id) {
        Result<TbBrand> result = brandService.findOne(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Result<String>> update(@RequestBody TbBrand tbBrand) {
        Result<String> result = brandService.update(tbBrand);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/delete/{ids}")
    public ResponseEntity<Result<String>> delete(@PathVariable(value = "ids") Long[] ids) {
        log.info(ids.toString());
        Result<String> delete = brandService.delete(ids);
        return ResponseEntity.ok(delete);
    }

    @PostMapping("/search")
    public ResponseEntity<Result<PageVo>> search(@RequestBody TbBrand tbBrand, int page, int size) {
        Result<PageVo> result = brandService.findPage(tbBrand, page, size);
        return ResponseEntity.ok(result);
    }
}
