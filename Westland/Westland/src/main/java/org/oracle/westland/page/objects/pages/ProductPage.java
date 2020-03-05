package org.oracle.westland.page.objects.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.oracle.westland.page.objects.BasePage;
import org.oracle.westland.utils.ElementExtension;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@title='print page']")
    private WebElementFacade printBtn;

    @FindBy(xpath = "//div[@id = 'breadcrumbTrail']//*")
    private List<WebElementFacade> breadcrumb;

    @FindBy(xpath = "//*[local-name()='svg']")
    private WebElementFacade barcode;

    //////////////////methods/////////////////////////
    public void clickBreadcrumbBar(String label) {
        ElementExtension.searchForNestedElement(breadcrumb, label).click();
    }

    public void verifyPrintWindowsOpen() {
//        getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        long start = System.currentTimeMillis();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

//        js.executeAsyncScript(
//                "var callback = arguments[1];" +
//                        "window.print = function(){callback();};" +
//                        "arguments[0].click();"
//                , printBtn);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String ms = (String) js.executeScript("return document.title");
        System.out.println("page title: " + ms);

        Boolean flag = (Boolean) js.executeScript(
                "let flag=false; " +
                        "window.print=()=>flag=true;" +
                        "document.getElementById('CC-prodDetails-printPage').click(); " +
                        "return flag;}");

        System.out.println(flag);

//        js.executeScript("window.setTimeout(500);");
//        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));

//        getDriver().switchTo().window(new ArrayList<String>(getDriver().getWindowHandles()).get(1));

        //System.out.println(flag);

    }

    ///////////////////////////verification section///////////////////////////////////////

    public boolean isElementClickable() {
        return ElementExtension.isClickable(breadcrumb.get(breadcrumb.size() - 1));
    }

    public void verifyProductPageDisplayed() {
        printBtn.shouldBeVisible();
        barcode.shouldBeVisible();
    }
}
