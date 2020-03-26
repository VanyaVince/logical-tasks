package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.oracle.westland.page.objects.BasePage;
import org.oracle.westland.utils.ElementExtension;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@title='print page']")
    private WebElementFacade printBtn;

    @FindBy(xpath = "//div[@id = 'breadcrumbTrail']//*")
    private List<WebElementFacade> breadcrumb;

    @FindBy(xpath = "//*[local-name()='svg']")
    private WebElementFacade barcode;

    @FindBy(xpath = "//button[@id='cc-prodDetailsAddToCart']")
    private WebElementFacade addToCartBtn;

    //////////////////methods/////////////////////////
    public void clickBreadcrumbBar(String label) {
        elementExtension.searchForNestedElement(breadcrumb, label).click();
    }

    public void clickAddToCartBtn() {
        withAction().moveToElement(addToCartBtn).build().perform();
        addToCartBtn.click();
    }

    ///////////////////////////verification section///////////////////////////////////////

    public boolean isElementClickable() {
        return elementExtension.isClickable(breadcrumb.get(breadcrumb.size() - 1));
    }

    public void verifyWindowPrintIsInvoked() {
        ((JavascriptExecutor) getDriver()).executeAsyncScript("var callback = arguments[1]; window.print = function(){callback();}; arguments[0].click();", printBtn);
    }

    public void verifyPageIsDisplayed() {
        printBtn.shouldBeVisible();
        barcode.shouldBeVisible();
    }
}
