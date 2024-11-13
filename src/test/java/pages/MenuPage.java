package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuPage extends CommonPage{

    By menuOption;

    /**
     * Constructor that defines element/s on Menu Page that are not defined with PageFactory
     */
    public MenuPage(){
        if(AppDriver.getReferenceOfDriver() instanceof AndroidDriver){
            menuOption = AppiumBy.accessibilityId("open menu");
        }else if(AppDriver.getReferenceOfDriver() instanceof IOSDriver){
            menuOption = AppiumBy.accessibilityId("TBD");
        }
    }

    @AndroidFindBy(accessibility = "menu item log in")
    @iOSXCUITFindBy(accessibility = "TBD")
    public WebElement menuLogin;

    @AndroidFindBy(accessibility = "menu item catalog")
    @iOSXCUITFindBy(accessibility = "TBD")
    public WebElement catalogOption;

    /**
     * Navigates to Login page of the app
     * On purpose the method contains two ways of locating elements (PageFactory and Selenium By)
     */
    public void navigateToLogin(){
        clickWhenElementPresent(menuOption);
        menuLogin.click();
    }

    public void navigateToCatalogue(){
        clickWhenElementPresent(menuOption);
        catalogOption.click();
    }
}
