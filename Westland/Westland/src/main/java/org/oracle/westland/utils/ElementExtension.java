package org.oracle.westland.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import org.testng.util.Strings;

import java.util.List;
import java.util.NoSuchElementException;

public class ElementExtension {

    public static WebElementFacade searchForNestedElement(List<WebElementFacade> elements, String label) {
        for (WebElementFacade element : elements) {
            if (element.getText().contains(label))
                return element;
        }
        throw new NoSuchElementException("No element exists");
    }

    public static boolean isClickable(WebElementFacade element) {
        return Strings.isNotNullAndNotEmpty(element.getAttribute("href"));
    }
}
