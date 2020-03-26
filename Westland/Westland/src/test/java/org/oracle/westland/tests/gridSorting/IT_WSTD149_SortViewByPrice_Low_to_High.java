package org.oracle.westland.tests.gridSorting;

import org.junit.Assert;
import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;
import org.oracle.westland.utils.SortingType;

public class IT_WSTD149_SortViewByPrice_Low_to_High extends PrimaryTemplate {

    private final String category = "Hardware";
    private final String subcategory = "Spades & Shovels";

    @Test
    public void verifyGridIsSortedByPrice_Low_to_High() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.sortProductsBy(SortingType.LOW_TO_HIGH.getValue());
        Assert.assertTrue("improper sorting",listingPage.shouldBeSortedBy("price", SortingType.LOW_TO_HIGH));
    }
}
