package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.HomePage;

public class HomePageSteps extends ScenarioSteps {

    private HomePage homePage;

    @Step
    public void openUrl() {
        homePage.open();
    }

    @Step
    public void clickTheCategory(String label) {
        homePage.clickOnElement(label);
    }

    @Step
    public void navigateToTheCategory (String label) {
        homePage.hoverOverElement(label);
    }

    @Step
    public void verifyHomePageAppearance() {
        homePage.verifyHomePageAppearance();
    }
}

