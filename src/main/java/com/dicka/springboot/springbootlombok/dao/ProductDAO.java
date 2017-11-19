/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.springboot.springbootlombok.dao;

import com.dicka.springboot.springbootlombok.model.Product;
import java.util.List;

/**
 *
 * @author java-spring
 */
public interface ProductDAO {
    
    Product insertProduct(Product product);
    
    Product updateProduct(Product product);
    
    void deleteProduct(Product product);
    
    Product findOneProduct(int idproduct);
    
    List<Product> findAllProduct();
    
    boolean ifProductIsExist(Product product);
}
