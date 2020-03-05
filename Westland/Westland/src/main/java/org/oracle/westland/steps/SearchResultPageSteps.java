package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.SearchResultPage;

public class SearchResultPageSteps extends ScenarioSteps {

    private SearchResultPage searchResultPage;

    @Step
    public void verifyProductsAreDisplayed(String label) {
        searchResultPage.verifyAllProductsContainMatchingWord(label);
    }

    @Step
    public void verifyMatchingProductsAreDisplayed(String label) {
        searchResultPage.verifyAdjustedMessageIsDisplayed();
        searchResultPage.verifyAllProductsContainMatchingWord(label);
    }

    @Step
    public void verifySuggestedSearchContains(String label) {
        searchResultPage.verifyNoSearchResultFieldIsDisplayed();
        searchResultPage.verifySuggestedSearchContains(label);
    }

    @Step
    public void verifyNoSearchResultAppearance() {
        searchResultPage.verifyNoSearchResultFieldIsDisplayed();
    }
}
