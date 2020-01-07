package pages.windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Base_page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Onliner_TV_page extends Base_page {

    private String url = "https://catalog.onliner.by/tv";
    public HashMap<String, String> windowHandles = new HashMap<String, String>();

    @FindBy(how = How.XPATH, using = "//div[@class='schema-filter__store-list']/a[contains(@href, 'apple')]")
    private WebElement appleStoreButton;

    @FindBy(how = How.XPATH, using = "//div[@class='schema-filter__store-list']/a[contains(@href, 'google')]")
    private WebElement googlePlayButton;

    @FindBy(how = How.XPATH, using = "//footer//a[normalize-space()='Реклама']")
    private WebElement advertisementButton;

    public Onliner_TV_page(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        openURL(url);
        windowHandles.put("Main page", lastWindowHandle());
    }

    public void openAppleStorePage() {
        appleStoreButton.click();
        windowHandles.put("Apple store", lastWindowHandle());
    }

    public void openGooglePlayPage() {
        googlePlayButton.click();
        windowHandles.put("Google play", lastWindowHandle());
    }

    public void openAdvertisement(){
        advertisementButton.click();
    }

    public void switchTo(String page){
        _driver.switchTo().window(windowHandles.get(page));
    }


    public void closeWindow(String page){
        windowHandles.remove(page);
        _driver.close();
    }

    public void closeAllWindows(){
        for (String page : windowHandles.values()){
            _driver.switchTo().window(page);
            _driver.close();
            windowHandles.remove(page);
        }
    }

    private String lastWindowHandle(){
        List<String> list = new ArrayList<String>(_driver.getWindowHandles());
        for (int i = 0; i < list.size(); i++){
            if (i == (list.size() - 1))
                return list.get(i);
        }
        return null;
    }

}
