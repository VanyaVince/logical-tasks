package org.oracle.westland.page.objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.oracle.westland.utils.ElementExtension;

import java.util.List;

public class BasePage extends PageObject {

    @FindBy(xpath = "//a[@id = 'CC-header-language-link']")
    protected WebElementFacade languageSwitcherBtn;

    @FindBy(xpath = "//div[contains(@class, 'flex-company')]//*[@alt='logo']")
    protected WebElementFacade westlandLogo;

    @FindBy(id = "//div[contains(@class, 'logo')]/following-sibling::div[contains(@class,'search')]//input")
    protected WebElementFacade searchBar;

    @FindBy(xpath = "//div[@id = 'dropdown-minicart']//a")
    protected WebElementFacade basketBtn;

    @FindBy(xpath = "//span[@id ='headerUserDropDown']//a[@type='button']")
    protected WebElementFacade accountBtn;

    protected ElementExtension elementExtension;

    public BasePage() { super();
        elementExtension = new ElementExtension();
    }

    public void clickOnLanguagePanel() {
        languageSwitcherBtn.click();
    }

    public void clickOnWestlandLogo() { westlandLogo.click(); }

    public void enterDataInSearchField(String label) {
        searchBar.typeAndEnter(label);
    }

    public void getMouseOverBasketBtn() {
        mouseOverElement(basketBtn);
    }

    public void clickBasketBtn() { basketBtn.click(); }

    ////////////////////////////////// base methods /////////////////////////////////////////////////////
    private void mouseOverElement(WebElementFacade el) {
        withAction().moveToElement(el).build().perform();
    }
}
