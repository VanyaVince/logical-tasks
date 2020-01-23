import driver.DriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import driver.DriverInstance;

public class BaseTest {

    DriverInstance _driver;

    @Before
    public void SetUp(){
        _driver = new DriverInstance(DriverType.CHROME);
        _driver.get_driver().manage().window().maximize();
    }

    @After
    public void TearDown(){
        _driver.get_driver().quit();
    }
}
