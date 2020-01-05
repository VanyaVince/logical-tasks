package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverInstance {

    private WebDriver _driver = null;

    public DriverInstance(DriverType driverType) {
        switch (driverType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                _driver = new FirefoxDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                _driver = new InternetExplorerDriver();
                break;
            default:
                break;
        }
        //_driver.manage().window().maximize();
    }
//
//    public WebDriver initializeDriver(DriverType driverType){
//      String _browserName = System.getProperty("browser", DriverType.CHROME.toString()).toUpperCase();
//        driverType = DriverType.valueOf(browser.toUpperCase());
//     return _driver;
//    }

    public WebDriver get_driver() {
        return _driver;
    }
}
