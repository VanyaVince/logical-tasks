package pages.windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Base_page;

public class Onliner_TV_page extends Base_page {

    public String url = "https://catalog.onliner.by/tv";

    @FindBy(how = How.XPATH, using = "//div[@class='schema-filter__store-list']/a[contains(@href, 'apple')]")
    private WebElement appleStoreButton;

    @FindBy(how = How.XPATH, using = "//div[@class='schema-filter__store-list']/a[contains(@href, 'google')]")
    private WebElement googlePlayButton;

    public Onliner_TV_page(WebDriver driver) {
        super(driver);
    }

    public void openAppleStorePage() {
        appleStoreButton.click();
    }

    public void openGooglePlayPage() {
        googlePlayButton.click();
    }



}
