using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Linq;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Remote;

namespace NUnitTestProject1
{
    public class Tests
    {
        //static ChromeOptions options = new ChromeOptions();

        private IWebDriver _driver;
        private DesiredCapabilities _capabilities;

        //private DesiredCapabilities capabilities = new DesiredCapabilities("chrome", "78.0.3904.108", Platform.CurrentPlatform);

        //private IWebDriver driver = new ChromeDriver();

        [SetUp]
        public void Setup()
        {
            _capabilities = new DesiredCapabilities();
            //options.AddAdditionalCapability("version", "78.0.3904.108");
        }

        [Test]
        public void InitializeChrome()
        {
            _driver = new ChromeDriver();
            _capabilities.SetCapability(CapabilityType.BrowserName, "chrome");
            _driver = new RemoteWebDriver(new Uri("http://localhost:4444/wd/hub"), _capabilities);

            _driver.Navigate().GoToUrl("https://github.com");
        }

        [Test]
        public void InitializeMozila()
        {
            _driver = new FirefoxDriver();
            _capabilities.SetCapability(CapabilityType.BrowserName, "firefox");
            _capabilities.SetCapability(capability: CapabilityType.Platform, new Platform(PlatformType.Windows));

            _driver.Navigate().GoToUrl("https://github.com");

        }
    }
}