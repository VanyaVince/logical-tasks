package org.oracle.westland.tests.unresolved;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class WhenOpenSubcategoryPageIsDisplayed extends PrimaryTemplate {

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Brands", "John Innes"},
                {"Bird Care", "Bird Tables"},
                {"Soils & Compost", "Growbags"},
                {"Hardware", "Spades & Shovels"}
        });
    }

    private final String category;
    private final String subcategory;

    public WhenOpenSubcategoryPageIsDisplayed(String category, String subcategory) {
        this.category = category;
        this.subcategory = subcategory;
    }

    @Test
    public void openLandingPage() throws InterruptedException {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.verifyListingPageAppearance();
    }


}
