package org.oracle.westland.page.objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage extends PageObject {

    @FindBy(xpath = "//a[@id = 'CC-header-language-link']")
    protected WebElementFacade languageSwitcherBtn;

    @FindBy(xpath = "//div[contains(@id, 'wrapper')]/ancestor::a//img")
    protected WebElementFacade westlandLogo;

    public void clickOnLanguagePanel() {
        languageSwitcherBtn.click();
    }

    public void clickOnWestlandLogo() {
        westlandLogo.click();
    }

    ////////////////////////////////// base methods /////////////////////////////////////////////////////
    protected void mouseOverElement(WebElementFacade el) {
        withAction().moveToElement(el).build().perform();
    }
}
