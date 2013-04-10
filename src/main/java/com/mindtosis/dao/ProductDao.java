package com.mindtosis.dao;

import com.mindtosis.models.Product;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Hoover
 * Date: 3/11/13
 * Time: 9:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> findAllproducts() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Product");
        return (List<Product>) query.list();
    }

}
