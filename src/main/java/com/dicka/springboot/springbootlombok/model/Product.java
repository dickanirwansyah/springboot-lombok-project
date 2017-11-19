/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.springboot.springbootlombok.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author java-spring
 */

@Entity
@Data
@Table(name = "product", 
        catalog = "dbrestfull")
public class Product implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idproduct;
    
    @Column(name = "nama", nullable = false)
    String nama;
    
    @Column(name = "description", nullable = false)
    String description;
    
    @Column(name = "price", nullable = false)
    int price;
    
    @Column(name = "vendor", nullable = false)
    String vendor;
    
    private Product(){}
}
