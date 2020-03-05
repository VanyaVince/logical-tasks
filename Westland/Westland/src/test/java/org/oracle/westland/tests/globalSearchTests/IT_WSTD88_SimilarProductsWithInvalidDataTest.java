package org.oracle.westland.tests.globalSearchTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD88_SimilarProductsWithInvalidDataTest extends PrimaryTemplate {

    private final String searchingProduct = "1esolva";
    private final String expectedResult = "Resolva";

    @Test
    public void verifyProductsAreDisplayedWithInvalidData() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.findProductWithSearchBar(searchingProduct);
        searchResultPage.verifyMatchingProductsAreDisplayed(expectedResult);
    }
}
