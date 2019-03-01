package ru.avalon.java.dev.ocpjp.labs;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) throws IOException {
        final Collection<Commodity> commodities = Commodity.random(100);
        /*
         * TODO(Студент): С использованием Java Stream API выполнить задачи из списка:
         * 1. Выполнить поиск самого дорого товара
         * 2. Найти товары с минимальным остатком
         * 3. Найти товары с остатком меньшим 5 и вывести в консоль их названия
         * 4. Подсчитать общую стоимость товаров с учётом их остатка
         * 5. Найти товар, с самым длинным названием и вывести его на экран
         * 6. Выполнить сортировку коллекции commodities
         * 7. Найти среднюю стоимость товаров
         * 8. Найти моду (медиану) стоимости товаров
         */


        //1
        Commodity mostExpensive = commodities.stream()
                .max(Comparator.comparingDouble(Commodity::getPrice))
                .get();
        System.out.println("\n>>Most expensive commodity:\n" + mostExpensive.getName()
                + "\nPrice: " + mostExpensive.getPrice());
        //2
        Commodity minResidue = commodities.stream()
                .min(Comparator.comparing(Commodity::getResidue))
                .get();
        System.out.println("\n>>Commodity's lowest residue:\n" + minResidue.getName()
                + "\nResidue: " + minResidue.getResidue());
        //3
        System.out.println("\n>>Commodity residue less than 5:");
        commodities.stream()
                .filter(n -> n.getResidue() < 5)
                .forEach(n -> System.out.println(n.getName() + " >>> Residue: " + n.getResidue()));
        //4
        double total = commodities.stream()
                .mapToDouble(n -> (n.getResidue() * n.getPrice()))
                .sum();
        System.out.print("\n>>Total cost of commodities: " + total);

        //5
        Commodity longestCommodity = commodities.stream()
                .max(Comparator.comparing(Commodity::getName))
                .get();
        System.out.println("\n>>the longest name: " + longestCommodity.getName());

        //6
        System.out.println("\n>>Sorting by Name: ");
        commodities.stream()
                .sorted(Comparator.comparing(Commodity::getName))
                .map(Commodity::getName)
                .forEach(System.out::println);

        //7
        System.out.print("\n>>Average price: " +
                commodities.stream()
                        .mapToDouble(Commodity::getPrice)
                        .average().getAsDouble()
        );

        //8
        System.out.println("\n>>mode of price: " + getMode(commodities));
    }


    /**
     * @return медиана стоимости товаров
     * @see <a href="https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D0%B4%D0%B8%D0%B0%D0%BD%D0%B0
     * _(%D1%81%D1%82%D0%B0%D1%82%D0%B8%D1%81%D1%82%D0%B8%D0%BA%D0%B0)">Медиана</a>
     */
    private static double getMode(Collection<Commodity> commodities) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}

