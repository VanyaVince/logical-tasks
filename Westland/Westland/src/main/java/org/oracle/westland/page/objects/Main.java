package org.oracle.westland.page.objects;

import net.sf.json.util.JSONUtils;
import org.oracle.westland.utils.Sorting;
import org.oracle.westland.utils.SortingType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList stringList = new ArrayList() {{
            add("azdf");
            add("asdf");
            add("asdf");
        }};

        double a = 60;
        double b = 3.99;

        DecimalFormat df = new DecimalFormat("0.00");
//        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(a * b));

        java.text.DecimalFormat dfs = new java.text.DecimalFormat("0.0000");
        double d = 1.1;
        System.out.println(d+" formatted is: "+dfs.format(d));
    }
}
