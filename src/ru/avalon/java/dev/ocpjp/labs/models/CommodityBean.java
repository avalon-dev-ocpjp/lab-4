package ru.avalon.java.dev.ocpjp.labs.models;

public class CommodityBean implements Commodity {

    String code;
    String vendorCode;
    String name;
    double price;
    int residue;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getVendorCode() {
        return vendorCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getResidue() {
        return residue;
    }
}
