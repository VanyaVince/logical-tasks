import org.junit.Test;
import steps.AlertPageSteps;

public class AlertTest extends BaseTest {

    private final String message = "Great Site";

    @Test
    public void alertTest() {

        AlertPageSteps alertPageSteps = new AlertPageSteps(_driver.get_driver());
        alertPageSteps.openUrl();
        alertPageSteps.closePopUpFooter();
        alertPageSteps.getTextFromSimpleAlert();
        alertPageSteps.getTextFromConfirmAlert();
        alertPageSteps.dismissConfirmAlert();
        alertPageSteps.fillOutPromptAlert(message);

    }
}
