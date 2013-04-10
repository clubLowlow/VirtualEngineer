package com.mindtosis.managedbeans;

import com.mindtosis.bo.ProductBo;
import com.mindtosis.models.DatabaseConnectionInfo;
import com.mindtosis.models.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: Hoover
 * Date: 3/17/13
 * Time: 3:16 PM
 */
public class ProductBean {

    private ProductBo productBo;

    private DatabaseConnectionInfo databaseConnectionInfo;

    public ProductBo getProductBo() {
        return productBo;
    }

    public void setProductBo(ProductBo productBo) {
        this.productBo = productBo;
    }

    public DatabaseConnectionInfo getDatabaseConnectionInfo() {
        return databaseConnectionInfo;
    }

    public void setDatabaseConnectionInfo(DatabaseConnectionInfo databaseConnectionInfo) {
        this.databaseConnectionInfo = databaseConnectionInfo;
    }

    public List<Product> getProductList(){
        return productBo.findAllProducts();
    }

    public String getHost(){
        return databaseConnectionInfo.getUrl();
    }

    public String getUsername(){
        return databaseConnectionInfo.getUsername();
    }

    public String getPassword(){
        return databaseConnectionInfo.getPassword();
    }
}
