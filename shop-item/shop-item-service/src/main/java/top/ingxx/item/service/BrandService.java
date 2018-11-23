package top.ingxx.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ingxx.item.dao.BrandDao;
import top.ingxx.item.pojo.Brand;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    public List<Brand> selectAll(){
        return brandDao.selectAll();
    }

}
