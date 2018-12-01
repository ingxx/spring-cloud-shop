package top.ingxx.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import top.ingxx.common.enums.ExceptionEnum;
import top.ingxx.common.exception.ShopException;
import top.ingxx.common.vo.PageVo;
import top.ingxx.common.vo.Result;
import top.ingxx.item.dao.TbBrandDao;
import top.ingxx.item.pojo.TbBrand;

import java.util.List;

@Slf4j
@Service
public class BrandService {

    @Autowired
    private TbBrandDao tbBrandDao;

    /***
     * 查询所有品牌
     * @return
     */
    public Result<List<TbBrand>> selectAll() {
        try {
            return Result.success(tbBrandDao.selectAll());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询失败", e);
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
            PageHelper.startPage(pageNum, pageSize); //分页助手
            Page<TbBrand> tbBrands = (Page<TbBrand>) tbBrandDao.selectAll(); //封装成pageVo返回
            return Result.success(new PageVo(tbBrands.getTotal(), tbBrands.getResult())); //封装成通用返回对象
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询失败", e);
            return Result.error(400, "查询失败");
        }
    }

    /***
     * 条件分页
     * @param tbBrand  查询条件实体
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    public Result<PageVo> findPage(TbBrand tbBrand, int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum,pageSize);
            Page<TbBrand> tbBrands = new Page<>();
            if(tbBrand != null){
                Example ex = new Example(TbBrand.class);
                Example.Criteria criteria = ex.createCriteria();
                if(StringUtil.isNotEmpty(tbBrand.getName())){
                    criteria.andLike("name","%"+ tbBrand.getName()+"%");
                }
                if (StringUtil.isNotEmpty(tbBrand.getFirstChar())){
                    criteria.andLike("firstChar","%"+ tbBrand.getFirstChar()+"%");
                }
                tbBrands = (Page<TbBrand>) tbBrandDao.selectByExample(ex);
            }
            return Result.success(new PageVo(tbBrands.getTotal(), tbBrands.getResult()));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询失败", e);
            return Result.error(400, "查询失败");
        }
    }

    /***
     * 新增品牌
     * @param tbBrand 新增对象
     * @return
     */
    public Result<String> add(TbBrand tbBrand) {
        if (tbBrand == null) {
            throw new ShopException(ExceptionEnum.INSTALL_BRAND_ERROR);
        }
        try {
            tbBrandDao.insert(tbBrand);
            log.info(tbBrand.toString());
            return Result.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("新增失败", e);
            return Result.error(400, "新增失败");
        }
    }

    /***
     * 根据ID查找品牌
     * @param id  商品ID
     * @return
     */
    public Result<TbBrand> findOne(Long id) {
        try {
            TbBrand tbBrand = tbBrandDao.selectByPrimaryKey(id);
            return Result.success(tbBrand);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询失败", e);
            return Result.error(400, "查询失败");
        }

    }

    /***
     * 更新品牌
     * @param tbBrand 品牌实体
     * @return
     */
    public Result<String> update(TbBrand tbBrand) {
        try {
            tbBrandDao.updateByPrimaryKey(tbBrand);
            return Result.success("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("更新失败", e);
            return Result.error(400, "更新失败");
        }
    }

    public Result<String> delete(Long[] ids) {
        try {
            for (Long id : ids) {
                tbBrandDao.deleteByPrimaryKey(id);
            }
            return Result.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除失败");
            return Result.error(400, "删除失败");
        }
    }


}
