package com.bitcamp.onemoaproject.service;

import com.bitcamp.onemoaproject.dao.ProductCategoryDao;
import com.bitcamp.onemoaproject.dao.ProductDao;
import com.bitcamp.onemoaproject.vo.product.Product;
import com.bitcamp.onemoaproject.vo.product.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductCategoryService implements ProductCategoryService {

  @Autowired
  ProductCategoryDao productCategoryDao;


  @Override
  public List<ProductCategory> list() {
    return productCategoryDao.findAll();
  }

}
