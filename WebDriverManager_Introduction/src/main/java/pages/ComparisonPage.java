package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComparisonPage extends BasePage {

    final private String label = "Диагональ экрана";
    final private By xpath_questionMark = By.xpath("//span[text()='"+ label +"']/following-sibling::div/span[contains(@data-tip-term,'"+ label +"')]");
    final private By xpath_tablePopTip = By.xpath("//div[@id='productTableTip']");
    final private By xpath_removingItem = By.xpath("//footer/../following-sibling::a");

    private WebElement questionMark = null;
    private WebElement tablePopTip = null;

    @FindBy(how = How.ID, using = "product-table")
    private WebElement mainTable;

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public void getQuestionableMark() {
        questionMark = mainTable.findElement(xpath_questionMark);
        hoverOverElement(questionMark);
    }

    public void openPopTipWindow() {
        questionMark.click();
        tablePopTip = _driver.findElement(xpath_tablePopTip);
        _wait.until(ExpectedConditions.visibilityOf(tablePopTip));
        hoverOverElement(tablePopTip);
    }

    public void closePopTipWindow() {
        questionMark.click();
        _wait.until(ExpectedConditions.invisibilityOf(tablePopTip));
    }

    public void removeItem(){
        mainTable.findElement(xpath_removingItem).click();
    }
}
