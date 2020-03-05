package org.oracle.westland.tests.globalSearchTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD87_NoResultMessageTest extends PrimaryTemplate {

    private final String searchingProduct = "123456";

    @Test
    public void verifyProductGridIsEmpty() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.findProductWithSearchBar(searchingProduct);
        searchResultPage.verifyNoSearchResultAppearance();
    }
}
