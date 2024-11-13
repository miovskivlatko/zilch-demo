package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPage extends CommonPage{

    @AndroidFindBy(accessibility = "Username input field")
    @iOSXCUITFindBy(accessibility = "TBD")
    public WebElement userName;

    @AndroidFindBy(accessibility = "Password input field")
    @iOSXCUITFindBy(accessibility = "TBD")
    public WebElement userPassword;

    @AndroidFindBy(accessibility = "Login button")
    @iOSXCUITFindBy(accessibility = "TBD")
    public WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    @iOSXCUITFindBy(xpath="TBD")
    public WebElement loginHeader;


    public void login(String name, String password) {
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginHeaderPresented() {
        try {
            return loginHeader.isDisplayed();
        } catch (NoSuchElementException e) {
            Logger.getAnonymousLogger().log(Level.INFO,"Login Header Web Element is not exising");
            return false;
        }
    }
}
