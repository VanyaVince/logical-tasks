package pages.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Base_page;

import java.util.List;

public class Onliner_TV_page extends Base_page {

    private String url = "https://catalog.onliner.by/tv";

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

    public String getUrl() {
        return url;
    }
}
