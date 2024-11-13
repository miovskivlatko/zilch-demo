package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ProductItemPage extends CommonPage {

    //xpath = "//android.widget.EditText[@resource-id=\"username\"]"
    @AndroidFindBy(accessibility = "Add To Cart button")
    @iOSXCUITFindBy(xpath="TBD")
    public WebElement addToCartButton;

    public boolean isAddToCartDisplayed() {
        return isElementPresented(addToCartButton);
    }
}
