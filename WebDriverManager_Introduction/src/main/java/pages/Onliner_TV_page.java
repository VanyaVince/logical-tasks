package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Onliner_TV_page extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='schema-product__group']")
    private List<WebElement> TVList;

    @FindBy(how = How.XPATH, using = "//div[@id='compare-button-container']//div[contains(@class, 'visible')]")
    private WebElement comparisonButton;

    public Onliner_TV_page(WebDriver driver) {
        super(driver);
    }

    public void takeFirstTwoTV() {
        int counter = 1;

        for (WebElement checkBoxes : TVList) {
            checkBoxes.findElement(By.tagName("label")).click();

            if (counter == 2)
                break;

            counter ++;
        }
    }

    public void ClickComparisonButton(){
        comparisonButton.findElement(By.xpath("//a[contains(@href, '+')]")).click();
    }
}
