/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.ocpjp.labs.models;

/**
 *
 * @author Victor.Malmygin
 */
public class CommodityImpl implements Commodity{
   
    private String code;
    
    private String vendorCode;
    
    private String name;
    
    private double price;
    
    private int residue;
    
    public void setCode(String code) {
        this.code = code;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getVendorCode() {
        return this.vendorCode;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getResidue() {
        return this.residue;
    }
    
}
