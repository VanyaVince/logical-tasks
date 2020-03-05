package org.oracle.westland.utils;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class DriverFinders {


    public static final String productContainer = ("//div[@class='prod_thumbnail']");
    public static final By productName = xpath(String.format("%s//div[@class='thumb_top']/a", productContainer));
    public static final By productPrice = xpath(String.format("%s//div[@class='thumb_bottom']/span", productContainer));

    public static final By dropdownLanguageWindow = xpath("//div[@id = 'languagedropdown']//div[@class='content']");
    public static final By iFrame = xpath("//iframe");
}
