package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.alert.Alert_page;

public class AlertPageSteps {

    public Alert_page homePageAlert;
    private Alert alert = null;

    public AlertPageSteps(WebDriver driver) {
        this.homePageAlert = new Alert_page(driver);
    }

    public void closePopUpFooter() {
        homePageAlert.clickFooterPopUp();
    }

    public void openUrl() {
        homePageAlert.openURL(homePageAlert.getUrl());
    }

    public void getTextFromSimpleAlert() {
        alert = homePageAlert.getSimpleAlert();
        homePageAlert.printValue(alert.getText());
        alert.accept();
    }

    public void getTextFromConfirmAlert() {
        alert = homePageAlert.getConfirmAlert();
        homePageAlert.printValue(alert.getText());
        alert.accept();
    }

    public void dismissConfirmAlert() {
        alert = homePageAlert.getConfirmAlert();
        alert.dismiss();

    }

    public void fillOutPromptAlert(String message) {
        alert = homePageAlert.getPromptAlert();
        homePageAlert.printValue(alert.getText());
        alert.sendKeys(message);
        alert.accept();
    }
}
