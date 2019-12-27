import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertTrue;

class CheckSauceLabsHomePageTestTest {

    WebDriver browser;
    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://saucelabs.com");
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    void site_header_is_on_home_page() {
        WebElement header = browser.findElement(By.id("headerMainNav"));
        assertTrue((header.isDisplayed()));
    }

    @AfterEach
    void tearDown() {
        browser.quit();
    }


}