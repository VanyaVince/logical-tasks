package org.oracle.westland.tests.basketTests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;
import org.oracle.westland.utils.AccountCredentials;

public class IT_WSTD_IncreaseProductQuantityViaBasketPage extends PrimaryTemplate {

    private final String category = "Bird Care";
    private final String subcategory = "Bird Feeders";
    private final String product = "Peckish Acorn Treat Feeder";

    @Test
    public void verify1() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify2() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify3() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify4() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify5() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify6() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify7() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify8() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify9() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    @Test
    public void verify10() {
        verifyProductPriceIsIncreasedWithItsQuantity();
    }

    //@Test
    public void verifyProductPriceIsIncreasedWithItsQuantity() {
        homePage.openUrl();
        logInPage.logInAs(AccountCredentials.LOGIN, AccountCredentials.PASSWORD);
        homePage.openCategory(category);
        homePage.openSubCategory(subcategory);
        listingPage.clickOnProduct(product);
        productPage.addProductToBasket();
        productPage.clickOnLogoItem();
        homePage.verifyHomePageAppearance();
//        homePage.openBasketPage();

        homePage.openBasketPopUpWindow();
        basketPopUpPage.expandBasketPage();
        basketPage.increaseProductQuantity(product);
        basketPage.verifyPriceIsChangedInterchangeablyWithQuantity(product);
    }
}