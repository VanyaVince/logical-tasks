package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.oracle.westland.page.objects.BasePage;
import org.oracle.westland.utils.DriverFinders;

@DefaultUrl("https://ccstore-test-zeqa.oracleoutsourcing.com/home")
public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'logo')]/following-sibling::div[contains(@class,'search')]//input")
    private WebElementFacade searchBar;

    @FindBy(xpath = "//div[@id='player']//button[contains(@class,'play-button')]//preceding-sibling::div/following-sibling::button")
    private WebElementFacade videoItem;

    @FindBy(xpath = "//span[@id ='headerUserDropDown']//a[@type='button']")
    private WebElementFacade accountButton;

    @FindBy(xpath = "//div[@id = 'dropdown-minicart']//a")
    private WebElementFacade cartButton;

    public void clickOnCategory(String label) {
        By locator = By.xpath(String.format("//li[@class='dropdown menu-item']/a[text()= '%s']", label));
        clickOnMenuItem(locator);
        mouseOverElement(westlandLogo);
    }

    public void clickOnSubcategory(String label) {
        By locator = By.xpath(String.format("//li[@class='subcategory-item']/a[@title= '%s']", label));
        clickOnMenuItem(locator);
    }

    /*currently is deprecated by Westland's documentation*/
    public void hoverOverElement(String label) {
        By locator = By.xpath(String.format("//li[@class='dropdown menu-item']/a[text()= '%s']", label));
        WebElementFacade element = waitFor((WebElementFacade) find(locator));
        mouseOverElement(element);
    }

    private void clickOnMenuItem(By loc) {
        WebElementFacade element = waitFor((WebElementFacade) find(loc));
        element.click();
    }

    public void enterDataInSearchField(String label) {
        searchBar.typeAndEnter(label);
    }

    ///////////////////////////verification section///////////////////////////////////////

    public void verifyPageAppearance() {
        getDriver().switchTo().frame((WebElement) find(DriverFinders.iFrame));
        videoItem.shouldBeVisible();
        getDriver().switchTo().defaultContent();
    }
}
