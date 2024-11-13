package system;

public class SysData {
    public static String mobilePlatform = System.getProperty("platform","android");
    private static final String appiumAutoRun = System.getProperty("appiumAutoRun","false");
    public static String envConfig = System.getProperty("envConfig","local");
    public static String apiEnv = System.getProperty("apiEnv","test");
    public static String gitHubRunner = System.getProperty("remoteGitHub","local");
    // example if we want to encapsulate the properties to not be getted directly
    public static String getAppiumAutoMode() {
        return appiumAutoRun;
    }
}
