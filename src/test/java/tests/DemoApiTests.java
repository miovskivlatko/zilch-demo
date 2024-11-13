package tests;

import RestModule.Common;
import endpoints.ProductCreate;
import endpoints.ProductGet;
import endpoints.WireMockEndpoint;
import enums.RestApiAuthTypes;
import enums.RestApiNames;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import system.SysData;
import system.WireMockBase;

import java.io.UnsupportedEncodingException;

import static io.restassured.RestAssured.patch;
import static io.restassured.RestAssured.post;
import static org.testng.AssertJUnit.fail;

public class DemoApiTests extends Common {
    String idOfCreatedProduct;

    @BeforeTest
    public void setupEnv() {
        String environment = SysData.apiEnv.toUpperCase();
        setRestApiName(RestApiNames.valueOf(environment));
        setRestApiAuthType(RestApiAuthTypes.TOKEN_AUTH);
        setup();
    }
    @Test
    public void firstCall() {
        ProductCreate productCreate = new ProductCreate();
        idOfCreatedProduct = productCreate.verifyAndReturnIdOfProductCreation();
    }

    @Test
    public void getProductById() throws UnsupportedEncodingException {
        ProductGet productGet = new ProductGet();
        Assert.assertTrue(productGet.getResponseCodeOnGetProduct(idOfCreatedProduct)==200,"Product not existing");
    }

    @Test
    public void testWireMockFunctionallity() throws UnsupportedEncodingException, InterruptedException {
        WireMockEndpoint wme = new WireMockEndpoint();
        WireMockBase.start();
        WireMockBase.configureAnExample();
        String responseBody = wme.getResponseForWireMockedCall();

       Assert.assertEquals(responseBody, WireMockBase.getWireMockMessage());

       WireMockBase.stop();


    }
}