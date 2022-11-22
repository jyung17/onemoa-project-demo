package com.bitcamp.onemoaproject.service.productService;

import com.bitcamp.onemoaproject.dao.product.ProductCategoryDao;
import com.bitcamp.onemoaproject.vo.product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DefaultProductCategoryService implements ProductCategoryService {

  @Autowired
  ProductCategoryDao productCategoryDao;


  @Override
  public List<ProductCategory> list() {
    return productCategoryDao.findAll();
  }

  @Override
  public List<Map> getSubCategories(String code) { return productCategoryDao.findByParent(code); }

  @Override
  public String getUpperCategory(String code) { return productCategoryDao.findByChild(code);}

  @Override
  public String getCategoryName(String code) { return productCategoryDao.findNameByCode(code);}
}
