package ru.avalon.java.dev.ocpjp.labs.models;

public class CommodityBuilderBean implements Commodity.CommodityBuilder {


    private CommodityBean dummy = new CommodityBean();

    @Override
    public Commodity.CommodityBuilder code(String code) {
        dummy.code = code;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder vendorCode(String vendorCode) {
        dummy.vendorCode = vendorCode;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder name(String name) {
        dummy.name = name;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder price(double price) {
        dummy.price = price;
        return this;
    }

    @Override
    public Commodity.CommodityBuilder residue(int residue) {

        dummy.residue = residue;
        return this;
    }

    @Override
    public Commodity build() {
        Commodity result = dummy;
        dummy = new CommodityBean();
        return  result;
    }
}
