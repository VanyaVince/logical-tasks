package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.ListingPage;
import org.oracle.westland.utils.Sorting;
import org.oracle.westland.utils.SortingType;

public class ListingPageSteps extends ScenarioSteps {

    private ListingPage listingPage;

    @Step
    public void clickOnProduct(String label) {
        listingPage.clickOnItem(label);
    }

    @Step
    public void openPreviousPageWithBreadcrumb(String label) {
        listingPage.verifyPageAppearance();
        listingPage.clickBreadcrumbBar(label);
    }

    @Step
    public void sortProductsBy(String by) {
        listingPage.selectSortingBy(by);
    }

    @Step
    public boolean shouldBeSortedBy(String by, SortingType type) {
        listingPage.verifyPageAppearance();
        return new Sorting().isSortedBy(listingPage.extractProductsBy(by), type);
    }

    @Step
    public void clickOnLogoItem() {
        listingPage.clickOnWestlandLogo();
    }

    @Step
    public boolean isLastBreadcrumbTrailInteractable() {
        listingPage.verifyPageAppearance();
        return listingPage.isElementClickable();
    }

    @Step
    public void verifyListingPageAppearance() {
        listingPage.verifyPageAppearance();
    }
}
