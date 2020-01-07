import org.junit.Assert;
import org.junit.Test;
import pages.windows.AppleStore_page;
import pages.windows.GooglePlay_page;
import pages.windows.Onliner_TV_page;

public class MultipleWindowsTest extends BaseTest {

    private final int windowsCount = 3;
    private final String expectedState = "complete";

    @Test
    public void windowsTest() throws InterruptedException {

        Onliner_TV_page onliner_tv_page = new Onliner_TV_page(_driver.get_driver());
        onliner_tv_page.openPage();
        onliner_tv_page.openAppleStorePage();
        onliner_tv_page.switchTo("Main page");
        onliner_tv_page.openGooglePlayPage();
        Assert.assertEquals(windowsCount, onliner_tv_page.windowHandles.size());

        onliner_tv_page.switchTo("Google play");

        GooglePlay_page googlePlay_page = new GooglePlay_page(_driver.get_driver());
        Assert.assertEquals("Page is not complete", expectedState, googlePlay_page.pageState());

        googlePlay_page.getSimilarApp();

        onliner_tv_page.switchTo("Apple store");

        AppleStore_page appleStore_page = new AppleStore_page(_driver.get_driver());
        appleStore_page.clickButtonMore();

        onliner_tv_page.closeWindow("Apple store");
        onliner_tv_page.switchTo("Main page");
        onliner_tv_page.openAdvertisement();
        onliner_tv_page.closeAllWindows();
    }
}
