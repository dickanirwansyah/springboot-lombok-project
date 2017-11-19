/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicka.springboot.springbootlombok.exception;

/**
 *
 * @author java-spring
 */
public class AlreadyException extends RuntimeException{
    
    public AlreadyException(final String message){
        super(message);
    }
}
