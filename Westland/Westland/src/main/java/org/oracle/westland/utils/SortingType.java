package org.oracle.westland.utils;

public enum SortingType {
    A_TO_Z("A to Z"),
    Z_TO_A("Z to A"),
    PRICE_HIGH_TO_LOW("Price high to low"),
    PRICE_LOW_TO_HIGH("Price low to high");

    private final String value;

    private SortingType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
