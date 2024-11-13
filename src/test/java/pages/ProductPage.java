package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends CommonPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    @iOSXCUITFindBy(xpath="TBD")
    public WebElement productHeader;


    @AndroidFindBy(accessibility = "sort button")
    @iOSXCUITFindBy(xpath="TBD")
    public WebElement sortButton;

    public boolean isProductHeaderPresent() {
        return isElementPresented(productHeader);
    }

    public boolean isSortButtonPresented() {
        return isElementPresented(sortButton);
    }

    public void scrollAndClickNow(String text) throws InterruptedException {
        scrollToElementByTextAndClick(text);
    }

}
