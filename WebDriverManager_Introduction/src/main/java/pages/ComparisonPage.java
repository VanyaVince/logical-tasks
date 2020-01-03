package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComparisonPage extends BasePage {

    @FindBy(how = How.ID, using = "product-table")
    private WebElement table;

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverItem(String elem){
        WebElement element = table.findElement(By.xpath("//span[text()='"+ elem +"']"));
        hoverOverElement(element);
    }

    public void clickQuestionableMark(String elem){
        WebElement questionableMark = _wait.until(ExpectedConditions.visibilityOf(table.findElement(By.xpath("//span[text()='"+ elem +"']/following-sibling::div/span"))));
        questionableMark.click();
    }
}
