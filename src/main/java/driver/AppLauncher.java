package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import system.DataLoader;
import system.SysData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.SkipException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppLauncher {

    static AppiumDriver driver;
    static AppiumDriverLocalService server;
    UiAutomator2Options options = new UiAutomator2Options();
    static DataLoader data = new DataLoader(SysData.envConfig);

    private static void buildServer() {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File(data.getAppiumJSPath()))
                .usingDriverExecutable(new File(data.getDriverExecutable()))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("Logfile.txt"))
                .withIPAddress(data.getIp());
        server = AppiumDriverLocalService.buildService(builder);


    }

    private static AppiumDriverLocalService getServer() {

        if (server == null) {
            buildServer();
        }
        return server;
    }

    public static void startAppium() {

        getServer().start();
    }

    public static void stopAppium() {

        if (server!=null) {
            getServer().stop();
        }
    }

    private static void androidStartApp() throws MalformedURLException {

       UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName(data.getDeviceName())
                .setPlatformVersion(data.getDevicePlatform())
                .setAppPackage(data.getAppPackage())
                .setPlatformName("android")
                .setAppActivity(data.getAppActivity());

        driver = new AndroidDriver(new URL(data.getAppiumUrl()),options);

        AppDriver.setDriver(driver);
    }

    private static void iOSStartApp() throws MalformedURLException {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone Example")
                .setPlatformVersion("")
                .setBundleId("");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
        AppDriver.setDriver(driver);
    }

    public static void installTheApp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(data.getDeviceName())
                .setApp(System.getProperty("user.dir") + data.getApkPath())
                .enforceAppInstall();
        driver = new AndroidDriver(new URL(data.getAppiumUrl()),options);

        AppDriver.setDriver(driver);
    }


public static void startApp() throws MalformedURLException {

        if (SysData.mobilePlatform.contains("ios")){
        iOSStartApp();
        }  else
            if (SysData.mobilePlatform.contains("android")) {
            androidStartApp();
        } else
        {
                throw new SkipException("Platform name is not correct");
        }
}

}
