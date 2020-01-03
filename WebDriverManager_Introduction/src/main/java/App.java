import driver.DriverInstance;
import driver.DriverType;
import pages.ComparisonPage;
import pages.Onliner_TV_page;

public class App {
    public static void main(String[] args) throws InterruptedException {

        DriverInstance driverInstance = new DriverInstance(DriverType.CHROME);

        Onliner_TV_page onliner_tv_page = new Onliner_TV_page(driverInstance.get_driver());

        onliner_tv_page.openURL();
        onliner_tv_page.takeFirstTwoTV();
        onliner_tv_page.ClickComparisonButton();

        ComparisonPage comparisonPage = new ComparisonPage(driverInstance.get_driver());
        comparisonPage.hoverOverItem("Диагональ экрана");
        comparisonPage.clickQuestionableMark("Диагональ экрана");


//        DriverInstance driverInstance = new DriverInstance();
//
//        for (DriverType driverType : DriverType.values()) {
//            WebDriver driver = driverInstance.initializeDriver(driverType.toString());
//            driver.get("https://www.toolsqa.com/selenium-c-sharp/");
//            Thread.sleep(2000);
//            driver.quit();
//        }

//        WebDriverManager.chromedriver().setup();
//        System.out.println(WebDriverManager.chromedriver().getBinaryPath());
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.toolsqa.com/selenium-c-sharp/");
//        driver.quit();
    }
}