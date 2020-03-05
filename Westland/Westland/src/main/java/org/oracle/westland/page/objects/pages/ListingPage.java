package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.oracle.westland.page.objects.BasePage;
import org.oracle.westland.utils.DriverFinders;
import org.oracle.westland.utils.ElementExtension;
import org.oracle.westland.utils.SortingType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ListingPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'breadcrumbTrail']//*")
    private List<WebElementFacade> breadcrumb;

    @FindBy(xpath = "//select[@id='CC-product-listing-sortby']")
    private WebElementFacade sortBy;

    //////////////////methods////////////////////////////////////////////////

    public void clickOnItem(String label) {
        find(By.xpath(String.format("//div[@class = 'prod_thumbnail']//a[text() = '%s']", label))).click();
    }

    public void clickBreadcrumbBar(String label) {
        ElementExtension.searchForNestedElement(breadcrumb, label).click();
    }

    public void selectSortingBy(String by) {
        sortBy.selectByVisibleText(by);

    }

    public List<String> extractProductsBy(SortingType by) {

        if (by == SortingType.A_TO_Z || by == SortingType.Z_TO_A)
            return findAll(DriverFinders.productName).stream().map(WebElementFacade::getText).collect(toList());

        else
            return findAll(DriverFinders.productPrice).stream().map(WebElementFacade::getText).collect(toList());
    }

    ///////////////////////////verification section///////////////////////////////////////

    public boolean isElementClickable() {
        return ElementExtension.isClickable(breadcrumb.get(breadcrumb.size() - 1));
    }

    public void verifyPageIsReloaded() {

//        shouldNotBeVisible(sortBy);
//        shouldBeVisible(find(By.xpath(DriverFinders.productContainer)));
//        WebElementFacade ele = find(By.xpath(DriverFinders.productContainer));
//        shouldNotBeVisible(ele);

        findBy(DriverFinders.productContainer).waitUntilNotVisible();
        verifyPageAppearance();

    }

    public void verifyPageAppearance() {
        sortBy.shouldBeVisible();
    }
}
