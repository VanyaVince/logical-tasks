package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.oracle.westland.page.objects.BasePage;

public class BasketPopUpPage extends BasePage {

    @FindBy(xpath = "//a[@id='CC-headerShoppingCart-Checkout']")
    private WebElementFacade goToBasketBtn;

//    @FindBy(xpath = "//a[@id='CC-headerShoppingCart-Edit']")
//    private WebElementFacade goToBasketBtn;

//    @FindBy(xpath = "//a[@id='CC-headerShoppingCart-Edit']/following-sibling::a")
//    private WebElementFacade emptyCartBtn;

    public void clickEditCartButton() {
        System.out.println(goToBasketBtn.getAttribute("href"));
        System.out.println(goToBasketBtn.getAttribute("data-bind"));
        goToBasketBtn.click();
    }
}
