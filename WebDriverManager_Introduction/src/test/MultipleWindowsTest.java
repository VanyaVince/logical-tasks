import org.junit.Assert;
import org.junit.Test;
import pages.windows.Onliner_TV_page;

public class MultipleWindowsTest extends BaseTest {

    final int windowsCount = 3;

    @Test
    public void windowsTest() throws InterruptedException {

        Onliner_TV_page onliner_tv_page = new Onliner_TV_page(_driver.get_driver());
        onliner_tv_page.openPage();
        onliner_tv_page.openAppleStorePage();
        onliner_tv_page.switchTo("Main page");
        onliner_tv_page.openGooglePlayPage();
        Assert.assertEquals(windowsCount, onliner_tv_page.windowHandles.size());
        onliner_tv_page.switchTo("Google play");
        onliner_tv_page.switchTo("Apple store");
    }
}
