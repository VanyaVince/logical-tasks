package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.oracle.westland.page.objects.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'breadcrumbTrail']//*")
    private List<WebElementFacade> breadcrumb;

    @FindBy(xpath = "//div[@id='main']//img")
    private WebElementFacade title;

    public void clickBreadcrumbBar(String label) {
         elementExtension.searchForNestedElement(breadcrumb, label).click();
    }

    ///////////////////////// verification section //////////////////////////

    public boolean isElementClickable() {
        return elementExtension.isClickable(breadcrumb.get(breadcrumb.size() - 1));
    }

    public void verifyPageAppearance() {
        title.shouldBeVisible();
    }

}
