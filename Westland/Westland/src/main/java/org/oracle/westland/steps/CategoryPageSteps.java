package org.oracle.westland.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.oracle.westland.page.objects.pages.CategoryPage;

public class CategoryPageSteps extends ScenarioSteps {

    private CategoryPage categoryPage;

    @Step
    public void openPreviousPageWithBreadcrumb(String label) {
        categoryPage.verifyPageAppearance();
        categoryPage.clickBreadcrumbBar(label);
    }

    @Step
    public boolean isLastBreadcrumbTrailInteractable() {
        categoryPage.verifyPageAppearance();
        return categoryPage.isElementClickable();
    }

    @Step
    public void verifyCategoryPageAppearance() {
        categoryPage.verifyPageAppearance();
    }
}
