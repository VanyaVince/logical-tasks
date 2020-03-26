package org.oracle.westland.steps;

import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.BasketPopUpPage;

public class BasketPopUpPageSteps extends ScenarioSteps {

    private BasketPopUpPage basketPopUpPage;

    public void expandBasketPage() {
        basketPopUpPage.clickEditCartButton();
    }
}
