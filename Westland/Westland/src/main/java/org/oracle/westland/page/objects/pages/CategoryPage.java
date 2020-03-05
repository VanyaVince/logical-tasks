package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.oracle.westland.page.objects.BasePage;
import org.oracle.westland.utils.ElementExtension;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'breadcrumbTrail']//*")
    private List<WebElementFacade> breadcrumb;

    @FindBy(xpath = "//div[@id='CC-guidedNavigation-accordionSection']//a[text()='Category']")
    private WebElementFacade categoryFilter;

    public void clickBreadcrumbBar(String label) {
        ElementExtension.searchForNestedElement(breadcrumb, label).click();
    }

    ///////////////////////// verification section //////////////////////////

    public boolean isElementClickable() {
        return ElementExtension.isClickable(breadcrumb.get(breadcrumb.size() - 1));
    }

    public void verifyPageAppearance() {
        categoryFilter.shouldBeVisible();
    }

}
