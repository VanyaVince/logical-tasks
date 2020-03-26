package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.oracle.westland.page.objects.BasePage;
import org.oracle.westland.utils.DriverFinders;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ListingPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'breadcrumbTrail']//*")
    private List<WebElementFacade> breadcrumb;

    @FindBy(xpath = "//div[@class='cc-product-listing-label']/..")
    private WebElementFacade sortByBoxFilter;

    @FindBy(xpath = "//select[@id='CC-product-listing-sortby']")
    private WebElementFacade sortBy;


    //////////////////methods////////////////////////////////////////////////

    public void clickOnItem(String label) {
        find(By.xpath(String.format("//div[@class = 'prod_thumbnail']//a[text() = '%s']", label))).click();
    }

    public void clickBreadcrumbBar(String label) {
        elementExtension.searchForNestedElement(breadcrumb, label).click();
    }

    public void selectSortingBy(String by) {
        sortBy.selectByVisibleText(by);
    }

    public List<String> extractProductsBy(String by) {

        if (by.toLowerCase().equals("name"))
            return findAll(DriverFinders.productNames).stream().map(WebElementFacade::getText).collect(toList());
        else
            return findAll(DriverFinders.productPrices).stream().map(WebElementFacade::getText).collect(toList());
    }

    ///////////////////////////verification section///////////////////////////////////////

    public boolean isElementClickable() {
        return elementExtension.isClickable(breadcrumb.get(breadcrumb.size() - 1));
    }

    public void verifyPageAppearance() {
        sortByBoxFilter.shouldBeVisible();
    }
}
