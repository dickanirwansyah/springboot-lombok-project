/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.springboot.springbootlombok.dao;

import com.dicka.springboot.springbootlombok.exception.AlreadyException;
import com.dicka.springboot.springbootlombok.model.Product;
import com.dicka.springboot.springbootlombok.reporsitory.ProductRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author java-spring
 */
@Transactional
@Validated
@Service
public class ProductDAOImpl implements ProductDAO{
    
    private ProductRepository productRepository;
    
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(ProductDAOImpl.class);
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
      LOGGER.info("insert data");
      Product existing = productRepository.findOne(product.getIdproduct());
      if(existing!=null){
          throw new AlreadyException(String.format("data dengan kode tersebut sudah ada", 
                  product.getIdproduct()));
      }
      return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
     LOGGER.debug("update data");
     if(!entityManager.contains(product))
         product = entityManager.merge(product);
     return product;
    }

    @Override
    public void deleteProduct(Product product) {
     LOGGER.debug("delete data");
     productRepository.delete(product);
    }

    @Override
    public Product findOneProduct(int idproduct) {
     LOGGER.debug("findone product");
     return productRepository.findOne(idproduct);
    }

    @Override
    public List<Product> findAllProduct() {
      LOGGER.info("show data");
      return productRepository.findAll();
    }

    @Override
    public boolean ifProductIsExist(Product product) {
     return findOneProduct(product.getIdproduct()) != null;
    }
    
}
