package org.oracle.westland.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import org.testng.util.Strings;

import java.text.DecimalFormat;
import java.util.List;
import java.util.NoSuchElementException;

public class ElementExtension {

    public WebElementFacade searchForNestedElement(List<WebElementFacade> elements, String label) {
//        System.out.println("elements size: " + elements.size());
        for (WebElementFacade element : elements) {
            if (element.getText().contains(label))
                return element;
        }
        throw new NoSuchElementException("No element exists");
    }

    public boolean isClickable(WebElementFacade element) {
        return Strings.isNotNullAndNotEmpty(element.getAttribute("href"));
    }

    public String multiple(String a, String b) {
        return new DecimalFormat("0.00").format(parseToDouble(a) * parseToDouble(b));
    }

    private Double parseToDouble(String msg) {
        return Double.parseDouble(msg.replaceAll("[^.0-9]", ""));
    }
}
