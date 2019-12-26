package edu.mum.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Stock implements Serializable {

  private static final long serialVersionUID = 1L;
  private String code = "";
  private double price = 0.0;
 
   
  public Stock() {
    
  }
  
  public Stock(String code, double price) {
    this.code = code;
    this.price = price;
  }
  
   
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
 }
