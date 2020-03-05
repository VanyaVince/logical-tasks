package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.oracle.westland.page.objects.BasePage;
import org.oracle.westland.utils.DriverFinders;
import org.oracle.westland.utils.ElementExtension;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@id='CC-product-listing-controls']//h3")
    private WebElementFacade adjustedMessage;

    @FindBy(xpath = "//div[@id='cc-productlisting-didYouMeanTerms']//span")
    private List<WebElementFacade> suggestedSearch;

    @FindBy(xpath = "//div[@id='CC-noSearchResults-display']")
    private WebElementFacade noSearchResultField;

    ////////////////////// verify ///////////////////////////
    public void verifyAllProductsContainMatchingWord(String label) {

        List<WebElementFacade> productNames = findAll(DriverFinders.productName);

        for (WebElementFacade name : productNames)
            name.shouldContainText(label);
    }

    public void verifyAdjustedMessageIsDisplayed() {
        adjustedMessage.shouldBeVisible();
    }

    public void verifyNoSearchResultFieldIsDisplayed() {
        noSearchResultField.shouldBeVisible();
    }

    public void verifySuggestedSearchContains(String label) {
        ElementExtension.searchForNestedElement(suggestedSearch, label);
    }
}
