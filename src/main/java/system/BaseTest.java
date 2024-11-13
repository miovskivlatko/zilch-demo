package system;

import driver.AppLauncher;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class BaseTest {


    @BeforeTest
    public void installApp() {
        if (SysData.getAppiumAutoMode().equals("true")) {
            AppLauncher.startAppium();
        }
    }
}
