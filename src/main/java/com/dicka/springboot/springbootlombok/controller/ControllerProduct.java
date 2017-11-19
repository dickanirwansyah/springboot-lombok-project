/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.springboot.springbootlombok.controller;

import com.dicka.springboot.springbootlombok.dao.ProductDAO;
import com.dicka.springboot.springbootlombok.model.Product;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author java-spring
 */
@RestController
@RequestMapping(value = "/api")
@Service
public class ControllerProduct {
    
    private ProductDAO productDAO;
    
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(ControllerProduct.class);
    
    @Autowired
    public ControllerProduct(ProductDAO productDAO){
        this.productDAO=productDAO;
    }
    
    @GetMapping(value = "/products/{idproduct}")
    public ResponseEntity<Product>findOneProduct(@PathVariable String idproduct){
        LOGGER.debug("get product");
        Product product = productDAO.findOneProduct(Integer.parseInt(idproduct));
        if(product == null){
            LOGGER.debug("data tidak ada");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>>findAllProduct(){
        LOGGER.debug("list products");
        List<Product> listproduct = productDAO.findAllProduct();
        if(listproduct.isEmpty()){
            LOGGER.debug("data tidak ada");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listproduct, HttpStatus.OK);
    }
}
