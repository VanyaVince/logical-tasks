package org.oracle.westland;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.oracle.westland.page.objects.pages.HomePage;
import org.oracle.westland.page.objects.pages.ListingPage;
import org.oracle.westland.steps.*;

@RunWith(SerenityRunner.class)
public class PrimaryTemplate {

    @Managed
    public WebDriver driver;

    @Managed
    public Pages pages;

    @Steps
    protected HomePageSteps homePage;

    @Steps
    protected LogInPageSteps logInPage;

    @Steps
    protected CategoryPageSteps categoryPage;

    @Steps
    protected ListingPageSteps listingPage;

    @Steps
    protected ProductPageSteps productPage;

    @Steps
    protected SearchResultPageSteps searchResultPage;
}
