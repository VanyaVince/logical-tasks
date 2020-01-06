import org.junit.Test;
import pages.windows.Onliner_TV_page;

public class MultipleWindowsTest extends BaseTest {

    @Test
    public void windowsTest() throws InterruptedException {

        Onliner_TV_page onliner_tv_page = new Onliner_TV_page(_driver.get_driver());

        onliner_tv_page.openURL(onliner_tv_page.url);
        onliner_tv_page.openAppleStorePage();

        _driver.get_driver().switchTo().window(_driver.get_driver().getWindowHandle());

        onliner_tv_page.openGooglePlayPage();


    }
}
