package driver;

import org.openqa.selenium.WebDriver;

public class AppDriver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static AppDriver instance = null;

    private AppDriver(){
    }

    public static AppDriver getReference(){

        if(instance==null){
            instance = new AppDriver();
        }
        return instance;
    }

    public WebDriver getDriver(){

        return driver.get();
    }

    public static WebDriver getReferenceOfDriver(){

        return getReference().getDriver();
    }

    public static void setDriver(WebDriver Driver){

        driver.set(Driver);
    }

}

