package com.mindtosis.bo;

import com.mindtosis.dao.ProductDao;
import com.mindtosis.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/17/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ProductBo {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public List<Product> findAllProducts() {
        return productDao.findAllproducts();
    }
}
