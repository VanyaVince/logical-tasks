package org.oracle.westland.tests.gridSorting;

import org.junit.Assert;
import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;
import org.oracle.westland.utils.SortingType;

public class IT_WSTD149_SortViewByPrice_High_to_Low extends PrimaryTemplate {

    private final String category = "Hardware";
    private final String subcategory = "Spades & Shovels";

    @Test
    public void verifyGridIsSortedByPrice_High_to_Low() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.sortProductsBy(SortingType.HIGH_TO_LOW.getValue());
        Assert.assertTrue("improper sorting",listingPage.shouldBeSortedBy("price", SortingType.HIGH_TO_LOW));
    }
}
