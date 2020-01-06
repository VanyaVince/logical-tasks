package pages.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Base_page;

public class Alert_page extends Base_page {

    private String url = "https://www.toolsqa.com/handling-alerts-using-selenium-webdriver/";

    @FindBy(how = How.XPATH, using = "//a[text()='ACCEPT']")
    private WebElement footerPopUp;

    @FindBy(how = How.XPATH, using = "//button[text()='Simple Alert']")
    private WebElement simpleAlert;

    @FindBy(how = How.XPATH, using = "//button[text()='Confirm Pop up']")
    private WebElement confirmAlert;

    @FindBy(how = How.XPATH, using = "//button[text()='Prompt Pop up']")
    private WebElement promptAlert;

    public Alert_page(WebDriver driver) {
        super(driver);
    }

    public void clickFooterPopUp(){
        _wait.until(ExpectedConditions.visibilityOf(footerPopUp));
        footerPopUp.click();
    }

    public Alert getSimpleAlert() {
        simpleAlert.click();
        _wait.until(ExpectedConditions.alertIsPresent());
        return _driver.switchTo().alert();
    }

    public Alert getConfirmAlert() {
        confirmAlert.click();
        _wait.until(ExpectedConditions.alertIsPresent());
        return _driver.switchTo().alert();
    }

    public Alert getPromptAlert() {
        promptAlert.click();
        _wait.until(ExpectedConditions.alertIsPresent());
        return _driver.switchTo().alert();
    }

    public String getUrl() {
        return url;
    }
}