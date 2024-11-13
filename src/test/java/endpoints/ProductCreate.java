package endpoints;

import RestModule.Common;
import RestModule.Deserialization.CreateProductResponse;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import system.SysData;
import system.UtilityMethods;



public class ProductCreate extends Common {

    String gitHubRunner = SysData.gitHubRunner;
    String path;

   public String verifyAndReturnIdOfProductCreation() {
       String pathWindows = "\\src\\main\\resources\\ApiData\\Requests\\createProduct.txt";
       String pathUnix = "/src/main/resources/ApiData/Requests/createProduct.txt";
        if (SysData.gitHubRunner.equals("github")) {
            path = pathUnix;
        } else if (SysData.gitHubRunner.equals("local")) {
            path = pathWindows;

       } else {
            Assert.fail("Argument for local or ci/cd runner is not correct. Should be github or local");
        }
       String body = UtilityMethods.getJsonBodyFromFile(System.getProperty("user.dir") + path);
       try {

           Response response = post(body, getRestApiUrl());
           Assert.assertTrue(response.getStatusCode() == 200);

           Gson gson = new Gson();
           CreateProductResponse createProductResponse = gson.fromJson(response.getBody().asString(), CreateProductResponse.class);
           return createProductResponse.getId();

       } catch (Exception e) {
           throw new RuntimeException(e);

       }
   }

}
