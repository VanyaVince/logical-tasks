package org.oracle.westland.page.objects;

public class Main {
    public static void main(String[] args) {
        String number = "££xfgh£3£.££9££9£";
        String a =number.replaceAll("[^.0-9]", "");

        System.out.println(a);
        Double i = Double.parseDouble(a);
        System.out.println(i);
    }
}
