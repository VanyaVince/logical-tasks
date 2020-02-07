package org.oracle.westland.tests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;

public class ITOpenLadingPageTest extends PrimaryTemplate {

    @Test
    public void openLandingPage() throws InterruptedException {
        homePageSteps.openUrl();
        //Thread.sleep(5000);
        homePageSteps.navigateToTheCategory("Brands");
        homePageSteps.clickTheCategory("John Innes");
        Thread.sleep(5000);
    }

}
