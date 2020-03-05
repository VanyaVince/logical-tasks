package org.oracle.westland.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Base64;

public class DriverInstance implements DriverSource {

    private WebDriver _driver = null;

    @Override
    public WebDriver newDriver() {

        String _systemBrowserProperty = System.getProperty("browser", DriverType.CHROME.toString()).toUpperCase();
        DriverType _driverType = DriverType.valueOf(_systemBrowserProperty);
        SeleniumProxyServer proxyServer = new SeleniumProxyServer();
        String credentials = "admin:admin";

        switch (_driverType) {
            case CHROME:
                ChromeOptions opts = new ChromeOptions();
                opts.setProxy(proxyServer.SetAuthorizationHeader(credentials));
                opts.setAcceptInsecureCerts(true);

                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver(opts);
                break;

            case FIREFOX:
                FirefoxOptions firexOpt = new FirefoxOptions();
                firexOpt.setProxy(proxyServer.SetAuthorizationHeader(credentials));
                firexOpt.setAcceptInsecureCerts(true);

                WebDriverManager.firefoxdriver().setup();
                _driver = new FirefoxDriver(firexOpt);
                break;
        }

        _driver.manage().window().maximize();
        return _driver;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}
