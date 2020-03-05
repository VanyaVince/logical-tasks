package org.oracle.westland.tests.gridSorting;

import org.junit.Assert;
import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;
import org.oracle.westland.utils.SortingType;

public class IT_WSTD149_SortViewBy_Z_to_A extends PrimaryTemplate {

    private final String category = "Hardware";
    private final String subcategory = "Spades & Shovels";

    @Test
    public void verifyGridIsSortedBy_A_to_Z() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.sortProductsBy(SortingType.Z_TO_A.getValue());
        Assert.assertTrue("improper sorting",listingPage.shouldBeSortedBy(SortingType.Z_TO_A));
    }
}
