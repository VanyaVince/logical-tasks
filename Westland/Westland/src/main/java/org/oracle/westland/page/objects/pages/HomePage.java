package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.oracle.westland.page.objects.BasePage;

import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://ccstore-test-zeqa.oracleoutsourcing.com/home")
public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'wrapper')]/ancestor::a//img")
    private WebElementFacade westlandLogo;

    @FindBy(xpath = "//div[contains(@class, 'logo')]/following-sibling::div[contains(@class,'search')]//input")
    private WebElementFacade searchBar;

    @FindBy(xpath = "//div[contains(@class, 'logo')]/following-sibling::div[contains(@class,'search')]//button")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//span[@id ='headerUserDropDown']//a[@type='button']")
    private WebElementFacade accountButton;

    @FindBy(xpath = "//div[@id = 'dropdown-minicart']//a")
    private WebElementFacade cartButton;

//    public void clickOnElement(String label) {
//        find(By.xpath("//li[@class='dropdown menu-item']/a[text()= '" + label + "']")).click();
//
//    }

    public void clickOnElement(String label) {
        find(By.xpath("//li[@class='subcategory-item']/a[@title= '" + label + "']")).click();

    }

    public void hoverOverElement(String label) {
        Actions actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.moveToElement(getDriver().findElement(By.xpath("//li[@class='dropdown menu-item']/a[text()= '" + label + "']"))).build().perform();
        //withAction().moveToElement(find(By.xpath("//li[@class='dropdown menu-item']/a[text()= '" + label + "']"))).build().perform();

    }

    ///////////////////////////verification section///////////////////////////////////////

    public void verifyHomePageAppearance() {

        westlandLogo.shouldBeVisible();
    }
}
