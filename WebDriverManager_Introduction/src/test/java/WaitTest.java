import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.wait.*;

public class WaitTest extends BaseTest {

    @Test
    public void waitTest() {

        Onliner_TV_page homePageOnliner_tv_ = new Onliner_TV_page(_driver.get_driver());

        homePageOnliner_tv_.openURL(homePageOnliner_tv_.getUrl());
        homePageOnliner_tv_.takeFirstTwoTV();
        homePageOnliner_tv_.ClickComparisonButton();

        Comparison_page comparisonPage = new Comparison_page(_driver.get_driver());

        comparisonPage.getQuestionableMark();
        comparisonPage.openPopTipWindow();
        comparisonPage.closePopTipWindow();
        comparisonPage.removeItem();

        Assert.assertTrue(comparisonPage._wait.until(ExpectedConditions.titleContains("Сравнить")));
    }
}