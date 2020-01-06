package pages.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Base_page;

public class Comparison_page extends Base_page {

    final private String label = "Диагональ экрана";
    final private By xpath_questionMark = By.xpath("//span[text()='"+ label +"']/following-sibling::div/span[contains(@data-tip-term,'"+ label +"')]");
    final private By xpath_tablePopTip = By.xpath("//div[@id='productTableTip']");
    final private By xpath_removingItem = By.xpath("//footer/../following-sibling::a");

    private WebElement questionMark = null;
    private WebElement popTipWindow = null;

    @FindBy(how = How.ID, using = "product-table")
    private WebElement mainTable;

    public Comparison_page(WebDriver driver) {
        super(driver);
    }

    public void getQuestionableMark() {
        questionMark = mainTable.findElement(xpath_questionMark);
        hoverOverElement(questionMark);
    }

    public void openPopTipWindow() {
        _wait.until(ExpectedConditions.visibilityOf(questionMark));
        questionMark.click();

        popTipWindow = _driver.findElement(xpath_tablePopTip);
        _wait.until(ExpectedConditions.visibilityOf(popTipWindow));

        hoverOverElement(popTipWindow);
    }

    public void closePopTipWindow() {
        questionMark.click();
        _wait.until(ExpectedConditions.invisibilityOf(popTipWindow));
    }

    public void removeItem() {
        mainTable.findElement(xpath_removingItem).click();
    }
}
