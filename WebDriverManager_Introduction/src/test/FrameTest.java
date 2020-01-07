import org.junit.Assert;
import org.junit.Test;
import pages.frame.FramePage;

public class FrameTest extends BaseTest {

    private final String text = "Hello";

    @Test
    public void textTheSameTest(){
        FramePage framePage = new FramePage(_driver.get_driver());

        framePage.openURL(framePage.url);
        framePage.fillOutInput(text);
    }
}
