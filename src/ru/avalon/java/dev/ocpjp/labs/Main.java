package ru.avalon.java.dev.ocpjp.labs;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

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
        Commodity max = commodities.stream()
                                    .max((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()))
                                    .get();
        System.out.println("most expensive:\n" + max.getName() + " costs " + max.getPrice());
        
        //2
        Commodity min = commodities.stream()
                                    .min((c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()))
                                    .get();
        System.out.println("cheapest:\n" + min.getName() + " costs " + min.getPrice());
        
        //3
        System.out.println("less then 5:");
        Collection<Commodity> list = commodities.stream()
                                                .filter((c) -> c.getResidue() < 5)
                                                .collect(Collectors.toList());
        list.forEach((c)->System.out.println(c.getName()));
        
        //4
        System.out.println("total:");
        Double sum = commodities.stream()
                                .reduce(0.0,
                                       (c1, c2) -> c1 + c2.getPrice()*c2.getResidue(),
                                       (c1, c2) -> c1 + c2);
        System.out.println(sum);
        
        //5
        System.out.println("the longest name:");
        commodities.stream()
                    .reduce((c1, c2) -> (c1.getName().compareTo(c2.getName()) < 0 ? c1 : c2))
                    .ifPresent((c) -> System.out.println(c.getName()));
        
        //6
        commodities.stream()
                   .sorted(Comparator.comparing(Commodity::getPrice))
                   .collect(Collectors.toList());
        
        //7
        System.out.println("average price:");
        commodities.stream()
                    .mapToDouble((c) -> c.getPrice())
                    .average()
                    .ifPresent(System.out::println);
        
        //8
        System.out.println("median price:");
        System.out.println((max.getPrice() - min.getPrice())/2);
    }
}
