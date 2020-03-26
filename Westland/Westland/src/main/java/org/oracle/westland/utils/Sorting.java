package org.oracle.westland.utils;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Sorting {

    public boolean isSortedBy(List<String> products, SortingType by) {

        boolean flag;
        List<Double> price;

        switch (by) {
            case A_TO_Z:
                flag = checkSorting(products, p -> products.get(p).compareTo(products.get(p + 1)) > 0);
                break;
            case Z_TO_A:
                flag = checkSorting(products, p -> products.get(p).compareTo(products.get(p + 1)) < 0);
                break;
            case LOW_TO_HIGH:
                price = parseToDouble(products);
                flag = checkSorting(parseToDouble(products), p -> price.get(p) > price.get(p + 1));
                break;
            case HIGH_TO_LOW:
                price = parseToDouble(products);
                flag = checkSorting(products, p -> price.get(p) < price.get(p + 1));
                break;
            default:
                throw new IllegalArgumentException(String.format("%s sorting does not exist", by));
        }
        return flag;
    }

    private <T> boolean checkSorting(List<T> list, Callable myFunc) {

        for (int i = 0; i < (list.size() - 2); i++) {
            if (myFunc.call(i))
                return false;
        }
        return true;
    }

    private List<Double> parseToDouble(List<String> list) {
        return list.stream().map(p -> p.replaceAll("[^.0-9]", "")).map(Double::parseDouble).collect(toList());
    }
}

