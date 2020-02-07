package org.oracle.westland.tests;

import org.junit.Test;
import org.oracle.westland.PrimaryTemplate;

public class ITOpenCategoryPageTest extends PrimaryTemplate {

    @Test
    public void OpenCategory() throws InterruptedException {
        homePageSteps.openUrl();
        homePageSteps.clickTheCategory("Brands");
    }
}
