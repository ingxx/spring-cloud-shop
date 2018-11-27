package top.ingxx.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ingxx.common.enums.ExceptionEnum;
import top.ingxx.common.exception.ShopException;
import top.ingxx.common.vo.PageVo;
import top.ingxx.common.vo.Result;
import top.ingxx.item.dao.BrandDao;
import top.ingxx.item.pojo.Brand;

import java.util.List;

@Slf4j
@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    /***
     * 查询所有品牌
     * @return
     */
    public Result<List<Brand>> selectAll() {
        try {
            return Result.success(brandDao.selectAll());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询失败",e);
            return Result.error(400, "查询失败");
        }

    }

    /***
     * 分页查询品牌
     * @param pageNum 当前页面数
     * @param pageSize  页面显示条数
     */
    public Result<PageVo> findPage(int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            Page<Brand> brands = (Page<Brand>) brandDao.selectAll();
            return Result.success(new PageVo(brands.getTotal(), brands.getResult()));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询失败",e);
            return Result.error(400, "查询失败");
        }

    }

    /***
     * 新增品牌
     * @param brand 新增对象
     * @return
     */
    public Result<String> add(Brand brand) {
        if (brand == null) {
            throw new ShopException(ExceptionEnum.INSTALL_BRAND_ERROR);
        }
        try {
            brandDao.insert(brand);
            return Result.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("新增失败",e);
            return Result.error(400,"新增失败");
        }
    }

    /***
     * 根据ID查找品牌
     * @param id  商品ID
     * @return
     */
    public Result<Brand> findOne(Long id) {
        try {
            Brand brand = brandDao.selectByPrimaryKey(id);
            return Result.success(brand);
        }catch (Exception e) {
            e.printStackTrace();
            log.error("查询失败",e);
            return Result.error(400,"查询失败");
        }

    }

    public Result<String> update(Brand brand){
       try{
           brandDao.updateByPrimaryKey(brand);
           return Result.success("更新成功");
       }catch (Exception e){
           e.printStackTrace();
           log.error("更新失败",e);
           return Result.error(400,"更新失败");
       }
    }
}
