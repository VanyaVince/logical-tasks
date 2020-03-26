package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.BasketPage;

public class BasketPageSteps extends ScenarioSteps {
    private BasketPage basketPage;

    @Step
    public void increaseProductQuantity(String label) {
        basketPage.clickAddIncreaseBtn(label);
    }

    @Step
    public void verifyPriceIsChangedInterchangeablyWithQuantity(String label) {
        basketPage.verifyPriceIsChanged(label);
    }
}
