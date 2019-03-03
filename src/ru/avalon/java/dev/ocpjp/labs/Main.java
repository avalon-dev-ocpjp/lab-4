package ru.avalon.java.dev.ocpjp.labs;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            final Collection<Commodity> commodities = Commodity.random(100);

            // Выполнить поиск самого дорого товара
            Optional<Commodity> mostExpensiveCommodity = commodities
                    .stream()
                    .max(Comparator.comparingDouble(Commodity::getPrice));

            // Найти товары с минимальным остатком
            int minResidue = commodities
                    .stream()
                    .mapToInt(Commodity::getResidue)
                    .summaryStatistics()
                    .getMin();

            Stream<Commodity> scarceCommodities = commodities
                    .stream()
                    .filter(c -> c.getResidue() == minResidue);

            // Найти товары с остатком меньшим 5 и вывести в консоль их названия
            System.out.println("Товары с остатком меньшим 5:");
            commodities
                    .stream()
                    .filter(c -> c.getResidue() < 5)
                    .map(Commodity::getName)
                    .forEach(System.out::println);

            // Подсчитать общую стоимость товаров с учётом их остатка
            double totalPrice = commodities
                    .stream()
                    .mapToDouble(c -> c.getPrice() * c.getResidue())
                    .summaryStatistics()
                    .getSum();

            // Найти товар с самым длинным названием и вывести его на экран
            System.out.println("Товар с самым длинным названием:");
            commodities
                    .stream()
                    .max(Comparator.comparingInt(c -> c.getName().length()))
                    .ifPresent(System.out::println);

            // Выполнить сортировку коллекции commodities
            Stream<Commodity> sortedStream = commodities
                    .stream()
                    .sorted( Comparator.comparingInt(c -> Integer.valueOf(c.getCode())) );

            // Найти среднюю стоимость товаров
            double avgPrice = commodities
                    .stream()
                    .mapToDouble(Commodity::getPrice)
                    .summaryStatistics()
                    .getAverage();

            // Найти медиану стоимости товаров
            double median = 0.0;
            OptionalDouble optional = OptionalDouble.empty();

            DoubleStream prices = commodities
                    .stream()
                    .mapToDouble(Commodity::getPrice)
                    .sorted();

            if(commodities.size() % 2 == 0) {
                median = prices
                        .skip(commodities.size() / 2 - 1)
                        .limit(2)
                        .sum() / 2;
            } else {
                optional = prices
                        .skip(commodities.size() / 2)
                        .findFirst();
                if(optional.isPresent())
                    median = optional.getAsDouble();
            }
        } catch(NullPointerException e) {
            System.err.println("NullPointerException! Obviously Commodity.random(int limit) method returned null");
        }
    }
}
