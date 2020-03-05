package org.oracle.westland.tests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD94_ProductPageViewTest extends PrimaryTemplate {

    private final String category = "Soils & Compost";
    private final String subcategory = "Barks & Aggregates";
    private final String product = "Bed & Border Chipped Bark";

    @Test
    public void openProductPage() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.clickOnProduct(product);
        productPage.verifyPageAppearance();
    }
}