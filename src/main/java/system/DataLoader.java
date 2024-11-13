package system;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Data loader class to load properties
 */
public class DataLoader {
    private static final String RESOURCE_CUSTOMERS_PROPERTY = "Configs/";
    private final String deviceName;
    private final String devicePlatform;
    private final String appPackage;
    private final String appActivity;
    private final String appiumJSPath;
    private final String ip;
    private final String driverExecutable;
    private final String apkPath;
    private final String appiumUrl;

    public DataLoader(String instance) {
        Properties properties = new Properties();

        try {
            InputStream propertiesStream = this.getClass().getClassLoader()
                    .getResourceAsStream(RESOURCE_CUSTOMERS_PROPERTY + instance + "/configuration.properties");
            properties.load(propertiesStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.deviceName = Objects.requireNonNull(properties.getProperty("deviceName"));
        this.devicePlatform = Objects.requireNonNull(properties.getProperty("devicePlatform"));
        this.appPackage = Objects.requireNonNull(properties.getProperty("appPackage"));
        this.appActivity = Objects.requireNonNull(properties.getProperty("appActivity"));
        this.appiumJSPath = Objects.requireNonNull(properties.getProperty("appiumJSPath"));
        this.ip = Objects.requireNonNull(properties.getProperty("ip"));
        this.driverExecutable = Objects.requireNonNull(properties.getProperty("driverExecutable"));
        this.apkPath = Objects.requireNonNull(properties.getProperty("apkPath"));
        this.appiumUrl = Objects.requireNonNull(properties.getProperty("appiumUrl"));

    }

    public String getDeviceName() {
        return deviceName;
    }
    public String getDevicePlatform() {
        return devicePlatform;
    }
    public String getAppPackage() {
        return appPackage;
    }
    public String getAppActivity() {
        return appActivity;
    }
    public String getAppiumJSPath() {
        return appiumJSPath;
    }
    public String getIp() {
        return ip;
    }
    public String getDriverExecutable() {
        return driverExecutable;
    }
    public String getApkPath() {
        return apkPath;
    }
    public String getAppiumUrl() {
        return appiumUrl;
    }
}
