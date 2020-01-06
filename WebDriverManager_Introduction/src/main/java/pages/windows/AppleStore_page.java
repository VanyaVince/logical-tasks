package pages.windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Base_page;

public class AppleStore_page extends Base_page {

    @FindBy(how = How.ID, using = "//div[@class='section__description']//button")
    private WebElement additionalInfoButton;

    public AppleStore_page(WebDriver driver) {
        super(driver);
    }


}
