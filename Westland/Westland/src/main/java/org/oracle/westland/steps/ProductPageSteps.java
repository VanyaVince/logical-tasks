package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.ProductPage;

public class ProductPageSteps extends ScenarioSteps {

    private ProductPage productPage;

    @Step
    public void openPreviousPageWithBreadcrumb(String label) {
        productPage.verifyProductPageDisplayed();
        productPage.clickBreadcrumbBar(label);
    }

    @Step
    public boolean isLastBreadcrumbTrailInteractable() {
        productPage.verifyProductPageDisplayed();
        return productPage.isElementClickable();
    }

    @Step
    public void verifyPrintWindowsOpen() {
        productPage.verifyPrintWindowsOpen();
    }

    @Step
    public void verifyPageAppearance() {
        productPage.verifyProductPageDisplayed();
    }
}
