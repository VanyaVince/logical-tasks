package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.oracle.westland.page.objects.BasePage;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//input[@id ='wgt-login__email']")
    private WebElementFacade loginField;

    @FindBy(xpath = "//input[@id ='wgt-login__password']")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//input[@id ='wgt-login__password']/../following-sibling::div/button[@type='submit']")
    private WebElementFacade logInBtn;

    public void enterLoginField(String login) {
        loginField.type(login);
    }

    public void enterPasswordField(String password) {
        passwordField.type(password);
    }

    public void clickLogInButton() {
        logInBtn.click();
    }

    ///////////////////////////verification section///////////////////////////////////////
}
