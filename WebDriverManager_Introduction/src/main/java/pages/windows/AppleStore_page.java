package pages.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Base_page;

public class AppleStore_page extends Base_page {

    @FindBy(how = How.XPATH, using = "//div[@class='section__description']//button")
    private WebElement additionalInfoButton;

    public AppleStore_page(WebDriver driver) {
        super(driver);
    }

    public void clickButtonMore(){
        additionalInfoButton.click();
    }


}
