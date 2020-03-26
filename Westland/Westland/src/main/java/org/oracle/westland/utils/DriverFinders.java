package org.oracle.westland.utils;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class DriverFinders {

    public static final By productNames = xpath("//div[@class='prod_thumbnail']//div[@class='thumb_top']/a");
    public static final By productPrices = xpath("//div[@class='prod_thumbnail']//div[@class='thumb_bottom']/span");

    public static final By dropdownLanguageWindow = xpath("//div[@id = 'languagedropdown']//div[@class='content']");
    public static final By iFrame = xpath("//iframe");
}
