package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.HomePage;
import org.oracle.westland.page.objects.pages.LogInPage;

public class LogInPageSteps extends ScenarioSteps {

    private LogInPage logInPage;
    private HomePage homePage;

    @Step
    public void logInAs(String login, String password) {
        logInPage.enterLoginField(login);
        logInPage.enterPasswordField(password);
        logInPage.clickLogInButton();
        homePage.verifyPageAppearance();
    }

}
