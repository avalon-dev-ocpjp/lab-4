package ru.avalon.java.dev.ocpjp.labs.models;

public class CommodityBuilderBean implements Commodity.CommodityBuilder {

    private String code;
    private String vendorCode;
    private String name;
    private double price;
    private int residue;

    @Override
    public Commodity.CommodityBuilder code(String code) {
        this.code = code;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder vendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder price(double price) {
        this.price = price;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder residue(int residue) {
        this.residue = residue;
        return this;
    }

    @Override
    public Commodity build() {
        return (Commodity) this;
    }
}
