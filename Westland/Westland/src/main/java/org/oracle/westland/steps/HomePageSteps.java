package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.HomePage;
import org.oracle.westland.page.objects.pages.ListingPage;
import org.oracle.westland.utils.DriverFinders;

public class HomePageSteps extends ScenarioSteps {

    private HomePage homePage;
    private ListingPage listingPage;

    @Step
    public void openUrl() {
        homePage.open();
    }

    @Step
    public void openCategory(String label) {
        homePage.clickOnCategory(label);
    }

    @Step
    public void openSubCategory(String label) {
        homePage.clickOnSubcategory(label);
        listingPage.verifyPageAppearance();
    }

    @Step
    public void navigateToCategory(String label) {
        homePage.hoverOverElement(label);
    }

    @Step
    public void findProductWithSearchBar(String label) {
        homePage.enterDataInSearchField(label);

    }

    ////////////////////verify////////////////////////
    @Step
    public void shouldSeeLanguagePanel() {
        homePage.clickOnLanguagePanel();
        homePage.shouldBeVisible(DriverFinders.dropdownLanguageWindow);
    }

    @Step
    public void verifyHomePageAppearance() {
        homePage.verifyPageAppearance();
    }
}

