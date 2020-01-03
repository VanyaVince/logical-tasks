package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver _driver;
    private Actions _actions;
    protected WebDriverWait _wait;

    private String url = "https://catalog.onliner.by/tv";

    BasePage(WebDriver driver) {
        this._driver = driver;
        PageFactory.initElements(driver, this);
        this._actions = new Actions(driver);
        this._wait = new WebDriverWait(_driver, 10, 500);
    }

    public void hoverOverElement(WebElement element){
        _actions.moveToElement(element).build().perform();
    }
    public void openURL(){
        _driver.get(url);
    }
}
