package org.oracle.westland.tests;

import org.junit.Assert;
import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD99_BreadcrumbsClickabilityTest extends PrimaryTemplate {

    private final String category = "Brands";
    private final String subcategory = "Resolva";
    private final String product = "Resolva Moss Killer Ready To Use";

    @Test
    public void verifyBreadcrumbsNavigation() {

        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.clickOnProduct(product);

        Assert.assertFalse("Element is a link", productPage.isLastBreadcrumbTrailInteractable());
        productPage.openPreviousPageWithBreadcrumb(subcategory);

        Assert.assertFalse("Element is a link", listingPage.isLastBreadcrumbTrailInteractable());
        listingPage.openPreviousPageWithBreadcrumb(category);

        Assert.assertFalse("Element is a link", categoryPage.isLastBreadcrumbTrailInteractable());
        categoryPage.openPreviousPageWithBreadcrumb("Home");

        homePage.verifyHomePageAppearance();
    }
}
