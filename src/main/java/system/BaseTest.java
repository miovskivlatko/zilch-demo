package system;

import driver.AppDriver;
import driver.AppLauncher;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class BaseTest {


    @BeforeTest
    public void installApp() throws MalformedURLException {
        if (SysData.getAppiumAutoMode().equals("true")) {
            AppLauncher.startAppium();
        }

        AppLauncher.installTheApp();
        AppDriver.getReferenceOfDriver().quit();

    }
}
