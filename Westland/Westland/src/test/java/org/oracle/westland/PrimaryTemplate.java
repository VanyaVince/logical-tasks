package org.oracle.westland;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.oracle.westland.page.objects.pages.HomePage;
import org.oracle.westland.steps.HomePageSteps;

@RunWith(SerenityRunner.class)
public class PrimaryTemplate {

    @Managed
    public WebDriver driver;

    @Managed
    public Pages pages;

    @Steps
    protected HomePageSteps homePageSteps;
}
