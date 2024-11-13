package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This page will be inherited from other Pages.
 * The page contains the constructor to init PageFactory model of finding elements
 * Here we can write common properties and methods that can be invoked from different pages and not to have repeat code
 * The example method here is if we want to use other location strategy - for example with findBy
 */

public class CommonPage {

    /**
     * Constructor
     * PageFactory is used to can use one WebElement for both Android and iOS
     */
    public CommonPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getReferenceOfDriver(),Duration.ofSeconds(10)), this);
    }

    WebDriverWait wait = new WebDriverWait(AppDriver.getReferenceOfDriver(), Duration.ofSeconds(30));

    protected WebElement getElement(By by){
        return AppDriver.getReferenceOfDriver().findElement(by);
    }


    protected WebElement waitForElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickWhenElementPresent(By by) {
        waitForElement(by).click();
    }

    public boolean isElementPresented(WebElement element) {
        return element.isDisplayed();
    }


    public void scrollToElementByTextAndClick(String text) throws InterruptedException {

        WebElement element = AppDriver.getReferenceOfDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
        //after scroll sometimes clicks outside the element field range
        //TBD customize method
        Thread.sleep(1000);
        element.click();
    }



}
