package org.oracle.westland.tests.headerNavigationTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD125_LogoRedirectToHomePage extends PrimaryTemplate {

    private final String category = "Soils & Compost";
    private final String subcategory = "Barks & Aggregates";

    @Test
    public void returnToHomeByClickingLogo() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.clickOnLogoItem();
        homePage.verifyHomePageAppearance();
    }
}
