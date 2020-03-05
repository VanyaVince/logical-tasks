package org.oracle.westland.tests.globalSearchTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD93_AlternativeSearchWithInvalidDataTest extends PrimaryTemplate {

    private final String searchingProduct = "weedff";
    private final String expectedResult = "weed";

    @Test
    public void verifySimilarTermsForSearchingIsShown() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.findProductWithSearchBar(searchingProduct);
        searchResultPage.verifySuggestedSearchContains(expectedResult);
    }
}
