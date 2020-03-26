package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.ProductPage;

public class ProductPageSteps extends ScenarioSteps {

    private ProductPage productPage;

    @Step
    public void openPreviousPageWithBreadcrumb(String label) {
        productPage.verifyPageIsDisplayed();
        productPage.clickBreadcrumbBar(label);
    }

    @Step
    public void addProductToBasket() {
        productPage.clickAddToCartBtn();
    }

    @Step
    public void clickOnLogoItem() {
        productPage.clickOnWestlandLogo();
    }

    @Step
    public boolean isLastBreadcrumbTrailInteractable() {
        productPage.verifyPageIsDisplayed();
        return productPage.isElementClickable();
    }

    @Step
    public void verifyWindowPrintIsInvoked() {
        productPage.verifyPageIsDisplayed();
        productPage.verifyWindowPrintIsInvoked();
    }

    @Step
    public void verifyPageAppearance() {
        productPage.verifyPageIsDisplayed();
    }
}
