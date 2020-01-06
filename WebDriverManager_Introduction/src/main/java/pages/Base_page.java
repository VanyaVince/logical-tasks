package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_page {

    protected WebDriver _driver;
    private Actions _actions;
    public WebDriverWait _wait;

    protected Base_page(WebDriver driver) {
        this._driver = driver;
        this._actions = new Actions(driver);
        this._wait = new WebDriverWait(_driver, 3, 500);
        PageFactory.initElements(driver, this);
    }

    protected void hoverOverElement(WebElement element) {
        _actions.moveToElement(element).build().perform();
    }

    public void printValue(String message) {
        System.out.println(message);
    }

    public void openURL(String url) {
        _driver.get(url);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
