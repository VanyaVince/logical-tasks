using System;
using System.Threading;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Xpath
{
    public class Tests
    {
        private IWebDriver _drive; 
        [SetUp]
        public void Setup()
        {
            _drive = new ChromeDriver();
            _drive.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(2);
            _drive.Manage().Window.Maximize();
            _drive.Navigate().GoToUrl("https://github.com/");
            
        }

        [Test]
        public void Xpath_1th()
        {
            var input = _drive.FindElement(By.XPath("//label/input"));
            input.SendKeys("WebDriver");
            _drive.FindElement(By.XPath(
                "//div[starts-with(@class, 'Box')]/descendant::li/following::li[starts-with(@id, 'jump-to')]/a")).Click();
        }

        [Test]
        public void Xpath_2th()
        {
            _drive.FindElement(By.XPath("//footer//li[contains(@class, 'flex-self-start')]/following-sibling::li/a"))
                .Click();
        }

        [TearDown]
        public void Close()
        {
            _drive.Quit();
        }
    }
}