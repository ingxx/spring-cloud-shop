package top.ingxx.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ingxx.common.vo.PageVo;
import top.ingxx.item.dao.BrandDao;
import top.ingxx.item.pojo.Brand;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    /***
     * 查询所有品牌
     * @return
     */
    public List<Brand> selectAll() {
        return brandDao.selectAll();
    }

    /***
     * 分页查询品牌
     * @param pageNum 当前页面数
     * @param pageSize  页面显示条数
     */
    public PageVo findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Brand> brands = (Page<Brand>) brandDao.selectAll();
        return new PageVo(brands.getTotal(), brands.getResult());
    }
}
