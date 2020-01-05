package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver _driver;
    private Actions _actions;
    public WebDriverWait _wait;

    private String url = "https://catalog.onliner.by/tv";

    BasePage(WebDriver driver) {
        this._driver = driver;
        this._actions = new Actions(driver);
        this._wait = new WebDriverWait(_driver, 3, 500);
        PageFactory.initElements(driver, this);
    }

    public void hoverOverElement(WebElement element){
        _actions.moveToElement(element).build().perform();
    }
    public void openURL(){
        _driver.get(url);
    }
}
