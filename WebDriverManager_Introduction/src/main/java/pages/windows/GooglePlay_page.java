package pages.windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Base_page;

public class GooglePlay_page extends Base_page {

    @FindBy(how = How.ID, using = "//div[starts-with(@class,'JNury')]/following-sibling::div//a[contains(text(),'more')]")
    private WebElement additionalInfoButton;

    public GooglePlay_page(WebDriver driver) {
        super(driver);
    }
}
