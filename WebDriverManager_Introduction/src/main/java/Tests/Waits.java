package Tests;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ComparisonPage;
import pages.Onliner_TV_page;

public class Waits extends BaseTest {

    @Test
    public void compareTV() {

        Onliner_TV_page onliner_tv_page = new Onliner_TV_page(_driver.get_driver());

        onliner_tv_page.openURL();
        onliner_tv_page.takeFirstTwoTV();
        onliner_tv_page.ClickComparisonButton();

        ComparisonPage comparisonPage = new ComparisonPage(_driver.get_driver());

        comparisonPage.getQuestionableMark();
        comparisonPage.openPopTipWindow();
        comparisonPage.closePopTipWindow();
        comparisonPage.removeItem();

        Assert.assertTrue(comparisonPage._wait.until(ExpectedConditions.titleContains("Сравнить")));
    }

}