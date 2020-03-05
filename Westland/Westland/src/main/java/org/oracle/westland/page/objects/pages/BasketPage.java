package org.oracle.westland.page.objects.pages;

import org.openqa.selenium.WebDriver;
import org.oracle.westland.page.objects.BasePage;

import java.util.Arrays;
import java.util.List;

public class BasketPage extends BasePage {


    public static class Util {
        static <T> T getValue(Object obj, Class<T> clazz) {
            return (T) obj;
        }

        static <T> T getValue(Object obj) {
            return (T) obj;
        }
    }

    public static void main(String[] args) {

        List list = Arrays.asList("Author", "Book");
        for (Object element : list) {
            String data = Util.getValue(element);
            System.out.println(Util.<String>getValue(element));
            System.out.println(Util.<String>getValue(element));
        }
    }
}
///////////////////////////verification section///////////////////////////////////////

