package org.oracle.westland.tests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;

public class ITPassHeaderAuthorizationTest extends PrimaryTemplate {

    ///////////////////////////// check out the connection and webdriver initialization //////////////////////////////////////////////////

    @Test
    public void GetWestlandSite() {
        homePageSteps.openUrl();
        homePageSteps.verifyHomePageAppearance();
        
    }
}
