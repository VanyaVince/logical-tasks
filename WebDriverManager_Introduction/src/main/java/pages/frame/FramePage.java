package pages.frame;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Base_page;

import java.util.concurrent.TimeUnit;

public class FramePage extends Base_page {

    public final String url = "http://jsbin.com/?html,output";

    private final String tag = "<input id=\"test\"/> ";

    @FindBy(how = How.XPATH, using = "//iframe[@class='stretch']")
    private WebElement outerFrame;

    @FindBy(how = How.XPATH, using = "//div[@id='sandbox-wrapper']/iframe")
    private WebElement innerFrame;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'activeline')]//span/parent::pre/span")
    private WebElement editField;

    @FindBy(how = How.ID, using = "test")
    public WebElement input;

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void fillOutInput(String text){
        new Actions(_driver).sendKeys(editField, tag).build().perform();
        _driver.switchTo().frame(outerFrame);
        sleep(1);
        _driver.switchTo().frame(innerFrame);
        input.sendKeys(text);
    }
}
