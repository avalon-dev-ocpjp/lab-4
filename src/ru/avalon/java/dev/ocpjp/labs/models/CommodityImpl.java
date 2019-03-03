package ru.avalon.java.dev.ocpjp.labs.models;

/**
 * Представление о товаре
 */
class CommodityImpl implements Commodity {
    /**
     * "Строитель", с помощью которого можно создавать
     * экземпляры типа {@link Commodity}
     */
    static class CommodityBuilderImpl implements CommodityBuilder {
        CommodityBuilderImpl() {}

        /**
         * Объект, инициализация которого выполняется в CommodityBuilderImpl
         */
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
            Commodity result = dummy;
            dummy = new CommodityImpl();
            return result;
        }
    }

    /**
     * Код товара
     */
    private String code;

    /**
     * Артикул товара
     */
    private String vendorCode;

    /**
     * Наименование товара
     */
    private String name;

    /**
     * Стоимость товара
     */
    private double price;

    /**
     * Остаток товара на складе
     */
    private int residue;

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

    @Override
    public String toString() {
        return "code='" + code + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", residue=" + residue;
    }
}
