package pages.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Base_page;

import java.util.List;

public class GooglePlay_page extends Base_page {

    private By similarApp = By.xpath("//h2[contains(text(), 'apps')]/../../following-sibling::div/div");

    @FindBy(how = How.XPATH, using = "//div[starts-with(@class,'JNury')]/following-sibling::div//a[contains(text(),'more')]")
    private WebElement additionalInfoButton;


    private JavascriptExecutor _executor;

    public GooglePlay_page(WebDriver driver) {
        super(driver);
        _executor = (JavascriptExecutor) driver;
    }

    public void getSimilarApp(){
        additionalInfoButton.click();
        _wait.until(ExpectedConditions.visibilityOfElementLocated(similarApp));
        List<WebElement> apps = _driver.findElements(similarApp);
        System.out.println("Number of similar application is: " + apps.size());
    }

    public String pageState() {
        return _executor.executeScript("return document.readyState").toString();
    }


}
