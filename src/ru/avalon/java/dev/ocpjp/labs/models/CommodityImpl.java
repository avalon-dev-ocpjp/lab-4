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
    
    class CommodityBuilderImpl implements CommodityBuilder{
        
        private CommodityImpl dummy = new CommodityImpl();

        @Override
        public CommodityBuilder code(String code) {
            dummy.code = code;
            return this;
        }

        @Override
        public CommodityBuilder vendorCode(String vendorCode) {
            dummy.vendorCode = vendorCode;
            return this;
        }

        @Override
        public CommodityBuilder name(String name) {
            dummy.name = name;
            return this;
        }

        @Override
        public CommodityBuilder price(double price) {
            dummy.price = price;
            return this;
        }

        @Override
        public CommodityBuilder residue(int residue) {
            dummy.residue = residue;
            return this;
        }

        @Override
        public Commodity build() {
            CommodityImpl result = dummy;
            dummy = new CommodityImpl();
            return result;
        }
    }
        
    private String code;
    
    private String vendorCode;
    
    private String name;
    
    private double price;
    
    private int residue;

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
