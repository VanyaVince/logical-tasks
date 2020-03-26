package org.oracle.westland.tests.globalSearchTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD203_SearchMainFlowTest extends PrimaryTemplate {

    private final String searchingProduct = "Resolva";

    @Test
    public void verifyGridContainsValidItems() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.findProductsWithSearchBar(searchingProduct);
        searchResultPage.verifyProductsAreDisplayed(searchingProduct);
    }
}
