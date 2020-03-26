package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.oracle.westland.page.objects.BasePage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BasketPage extends BasePage {

    @FindBy(xpath = "//div[@class='items-wrapper']//ancestor::div[@id='cc-cartSummary']")
    private WebElementFacade container;

    @FindBy(xpath = "//div[@class='row']/div[contains(@class, 'image')]")
    private WebElementFacade image;

    private String productQuantity = ("//ancestor::div[@class='item']/div[@class='row']//input[@class='quantity']");
    private String addIncreaseBtn = ("//ancestor::div[@class='item']/div[@class='row']//span[contains(@class,'plus')]/ancestor::button");
    private String petItemPrice = ("//ancestor::div[@class='item']/div[@class='row']//span[@class='unit-price']");
    private String productAmount = ("//ancestor::div[@class='item']/div[@class='row']//span[@class='amount']");


    public void clickAddIncreaseBtn(String productName) {

        waitUntilClick(waitOnPage(), productName, addIncreaseBtn);
    }

    private void waitUntilClick(WebDriverWait wait, String productName, String element) {

        wait.until(d -> {
            try {
                extractElement(productName, element).click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
    }

    private WebElementFacade extractElement(String productName, String containerElement) {
        container.waitUntilVisible();
        return find(By.xpath(String.format("//div[@class = 'item']//div[@class='row']//a[text()='%s']%s", productName, containerElement)));

    }

    //        while (true) {
//            if (extractElement(productName, addIncreaseBtn).isClickable()) {
//                return;
//            }
//        }




    private WebElement getElement(String productName, String containerElement) {
        return (WebElement) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{WebElement.class}, new InvocationHandler() {
            // Lazy initialized instance of WebElement
            private WebElement webElement;

            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                if (webElement == null) {
                    webElement = getDriver().findElement(By.xpath(String.format("//div[@class = 'item']//div[@class='row']//a[text()='%s']%s", productName, containerElement)));
                }
                return method.invoke(webElement, args);
            }
        });
    }

    private WebElementFacade getProductAmount(String element) {
        return extractElement(element, productAmount);
    }

    private WebElementFacade getProductQuantity(String element) {
        return extractElement(element, productQuantity);
    }

    private WebElementFacade getPerItemPrice(String element) {
        return extractElement(element, petItemPrice);
    }




    ///////////////////////////verification section///////////////////////////////////////

    public void verifyPriceIsChanged(String element) {
        String price = String.format("£%s", elementExtension.multiple(getPerItemPrice(element).getText(), getProductQuantity(element).getValue()));
        waitOnPage().until(d -> getProductAmount(element).getText().equals(price));
    }
}

//    private By addIncreaseBtn = By.xpath(".//ancestor::div[@class='item']/div[@class='row']//span[contains(@class,'plus')]/ancestor::button");
//    private By productQuantity = By.xpath(".//ancestor::div[@class='item']/div[@class='row']//input[@class='quantity']");
//    private By petItemPrice = By.xpath(".//ancestor::div[@class='item']/div[@class='row']//span[@class='unit-price']");
//    private By productAmount = By.xpath(".//ancestor::div[@class='item']/div[@class='row']//span[@class='amount']");