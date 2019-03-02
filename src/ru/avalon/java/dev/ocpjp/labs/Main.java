package ru.avalon.java.dev.ocpjp.labs;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    
    static double getMedian(double[] arr) {
        double median;
        if (arr.length % 2 == 0) {
            median = arr[(arr.length/2) + 1];
        } else {
            median = arr[arr.length/2];
        }
        return median;
    }
    
    public static void main(String[] args) throws IOException {
        final Collection<Commodity> commodities = Commodity.random(100);
        
        OptionalDouble maxPrice = commodities   .stream()
                                                .mapToDouble(Commodity::getPrice)
                                                .max();
        Consumer<Commodity> action = (Commodity) -> {
            if (Commodity.getPrice() == maxPrice.getAsDouble()) {
                System.out.println("Товар - " + Commodity.getName() + "с максимальной ценой " + Commodity.getPrice());                
            }
        };        
        commodities.forEach(action);
        System.out.println();
        
        OptionalInt minResidue = commodities    .stream()
                                                .mapToInt(Commodity::getResidue)
                                                .min();
        Consumer<Commodity> action2 = (Commodity) -> {
            if (Commodity.getResidue() <= minResidue.getAsInt()) {
                System.out.println("Товар - " + Commodity.getName() + " с минимальным остатком = " + Commodity.getResidue());                
            }
        };
        commodities.forEach(action2);
        System.out.println();
        
        Collection<Commodity> residueLessFive = commodities .stream()
                                                            .filter(Commodity -> Commodity.getResidue() < 5)
                                                            .collect(Collectors.toCollection(ArrayList::new));     
        residueLessFive.forEach(x -> System.out.println(x.getName()));
        System.out.println();
        
        double sum = commodities    .stream()
                                    .mapToDouble(x -> x.getPrice()*x.getResidue())
                                    .sum();        
        System.out.println("Общая стоимость товаров - "  + sum);
        System.out.println();
        
        String longName = commodities   .stream()
                                        .map(x -> x.getName())
                                        .max(Comparator.comparingInt(String::length)).get();
        System.out.println("Товар с самым длинным названием:\n" + longName);
        System.out.println();
        
        System.out.println("Сортирвка по именам:");
        commodities    .stream()
                       .sorted(Comparator.comparing(Commodity::getName))
                       .forEach(x -> System.out.println(x.getName()));
        System.out.println();
        
        double med = commodities    .stream()
                                    .mapToDouble(Commodity::getPrice)
                                    .average().getAsDouble();
        System.out.println("Средняя стоимость товаров - " + med);
        System.out.println();
        
        double[] mod = commodities    .stream()        
                                      .mapToDouble(Commodity::getPrice)
                                      .sorted()
                                      .toArray();
        System.out.println("Медианное значение " + getMedian(mod));
        mod = null;
    }            
}
