package ru.avalon.java.dev.ocpjp.labs.models;

import ru.avalon.java.dev.ocpjp.labs.core.Builder;
import ru.avalon.java.dev.ocpjp.labs.core.io.RandomFileReader;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Абстрактное представление о товаре.
 */
public interface Commodity {
    /**
     * Возвращает код товара.
     *
     * @return код товара в виде строки.
     */
    String getCode();

    /**
     * Возвращает артикул товара
     *
     * @return артикул товара в виде строки.
     */
    String getVendorCode();

    /**
     * Возвращает наименование товара.
     *
     * @return наименование товара в виде строки.
     */
    String getName();

    /**
     * Возвращает стоимость товара.
     *
     * @return стоимость товара.
     */
    double getPrice();

    /**
     * Возвращает остаток товара на складе.
     *
     * @return остаток товара.
     */
    int getResidue();

    /**
     * Абстрактное представление о реализации эталона
     * проектирования "Строитель" для типа данных {@link Commodity}.
     */
    interface CommodityBuilder extends Builder<Commodity> {
        /**
         * Устанавливает код товара.
         *
         * @param code код товара
         * @return экземпляр типа {@link CommodityBuilder}
         */
        CommodityBuilder code(String code);

        /**
         * Устанавливает артикул товара.
         *
         * @param vendorCode артикул товара
         * @return экземпляр типа {@link CommodityBuilder}
         */
        CommodityBuilder vendorCode(String vendorCode);

        /**
         * Устанавливает наименование товара.
         *
         * @param name наименование товара
         * @return экземпляр типа {@link CommodityBuilder}
         */
        CommodityBuilder name(String name);

        /**
         * Устанавливает стоимость товара.
         *
         * @param price стоимость товара
         * @return экземпляр типа {@link CommodityBuilder}
         */
        CommodityBuilder price(double price);

        /**
         * Устанавливает остаток товара на складе.
         *
         * @param residue остаток товара
         * @return экземпляр типа {@link CommodityBuilder}
         */
        CommodityBuilder residue(int residue);

        /**
         * Возвращает экземпляр типа {@link Commodity}
         * проинициализированный согласно заданной
         * конфигурации.
         *
         * @return экземпляр типа {@link Commodity}
         */
        @Override
        Commodity build();
    }

//    /**
//     * Возвращает "Строитель", с использованием которого
//     * можно создавать экземпляры типа {@link Commodity}.
//     *
//     * @return экземпляр типа {@link CommodityBuilder}
//     */
//    static CommodityBuilder builder() {
//        /*
//         * TODO(Студент): Реализовать метод 'builder()' типа 'Commodity'
//         * В рамках задачи потребуется создать реализацию
//         * интерфейса CommodityBuilder, что в свою очередь
//         * потребует создания реализации для интерфейса Commodity.
//         *
//         * Созданные реализации случше всего инкапсулировать
//         * на уровне пакета.
//         */
//        throw new UnsupportedOperationException("Not implemented yet!");
//    }

    /**
     * Выполняет создание заданного количества случайных
     * товаров.
     *
     * @param limit количество товаров в результирующей
     *              коллекции
     * @return коллекцию экземпляров {@link Commodity}
     * @throws IOException в случае ошибки ввода-вывода
     */
    static Collection<Commodity> random(int limit) throws IOException {
        try (RandomFileReader reader = RandomFileReader.fromSystemResource("resources/household.csv")) {
            Stream<String> stringStream = Stream.generate(reader::readLine).limit(limit);
            Stream<Commodity> commodityStream = stringStream.map(Commodity::valueOf);
            return commodityStream.collect(Collectors.toSet());
        }
    }

    /**
     * Выполняет создание экземпляра типа {@link Commodity}
     * из строки.
     *
     * @param string строка, содержащая данные о товаре
     * @return экземпляр типа {@link Commodity} или null, если строка
     * не может быть преобразована в экземпляр типа {@link Commodity}
     */
    static Commodity valueOf(String string) {
        /*
         * TODO(Студент): реализовать метод 'parse()' класса 'Commodity'
         * Реализация метода должна быть основана на формате
         * файла 'resources/household.csv'.
         */
        String[] arr = string.split(";");
        try {
            return CommodityImpl.builder()
                    .code(arr[0])
                    .vendorCode(arr[1])
                    .name(arr[2])
                    .residue(Integer.valueOf(arr[3]))
                    .price(Double.valueOf(arr[4]))
                    .build();
        } catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
