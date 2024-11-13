package tests;

import driver.AppLauncher;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import system.BaseTest;

import java.net.MalformedURLException;

public class DemoMobileTests extends BaseTest {
    MenuPage menuPage;
    LoginPage loginPage;
    ProductPage productPage;
    ProductItemPage productItemPage;

    @BeforeClass
    public void initPages() throws MalformedURLException {
        AppLauncher.startApp();
    }

    @Test(priority=1)
    public void validLoginTest(){
        menuPage = new MenuPage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        menuPage.navigateToLogin();
        Assert.assertTrue(loginPage.isLoginHeaderPresented(),"Product page was not open. Login failed");
        loginPage.login("bob@example.com","10203040");
        Assert.assertTrue(productPage.isProductHeaderPresent(),"Product page was not open. Login failed");
        menuPage.navigateToLogin();
        Assert.assertFalse(loginPage.isLoginHeaderPresented(),"User is not allowed to updates Checkout details as it is not logged in");
    }

    @Test(priority=2)
    public void buyAnItem() throws InterruptedException {
        productItemPage = new ProductItemPage();
        productPage.scrollAndClickNow("allTheThings");

        Assert.assertTrue(productItemPage.isAddToCartDisplayed());
    }

    @AfterMethod
    public void goToMainScreen() {
        menuPage.navigateToCatalogue();
        Assert.assertTrue(productPage.isSortButtonPresented());
    }

}
