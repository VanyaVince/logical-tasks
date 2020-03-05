package org.oracle.westland.utils;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Sorting {

    public boolean isSortedBy(List<String> products, SortingType by) {

        boolean flag;

        switch (by) {
            case A_TO_Z:
                flag = shouldBeSortedBy_A_to_Z(products);
                break;
            case Z_TO_A:
                flag = shouldBeSortedBy_Z_to_A(products);
                break;
            case PRICE_LOW_TO_HIGH:
                flag = shouldBeSortedByPrice_Low_to_High(products);
                break;
            case PRICE_HIGH_TO_LOW:
                flag = shouldBeSortedByPrice_High_to_Low(products);
                break;
            default:
                throw new IllegalArgumentException(String.format("%s does not exist", by));
        }
        return flag;
    }

    private boolean shouldBeSortedBy_A_to_Z(List<String> list) {

        for (int i = 0; i < (list.size() - 2); i++) {

            if (list.get(i).compareTo(list.get(i + 1)) > 0)
                return false;
        }
        return true;
    }

    private boolean shouldBeSortedBy_Z_to_A(List<String> list) {

        for (int i = 0; i < (list.size() - 2); i++) {

            if (list.get(i).compareTo(list.get(i + 1)) < 0)
                return false;
        }
        return true;
    }

    private boolean shouldBeSortedByPrice_Low_to_High(List<String> list) {

        List<Double> price = parseToDouble(list);

        for (int i = 0; i < (price.size() - 2); i++) {

            if (price.get(i) > (price.get(i + 1)))
                return false;
        }
        return true;
    }

    private boolean shouldBeSortedByPrice_High_to_Low(List<String> list) {

        List<Double> price = parseToDouble(list);

        for (int i = 0; i < (price.size() - 2); i++) {

            if (price.get(i) < (price.get(i + 1)))
                return false;
        }
        return true;
    }

    private List<Double> parseToDouble (List<String> list) {
        return list.stream().map(p -> p.replaceAll("[^.0-9]", "")).map(Double::parseDouble).collect(toList());
    }
}

