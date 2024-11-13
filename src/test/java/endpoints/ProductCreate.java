package endpoints;

import RestModule.Common;
import RestModule.Deserialization.CreateProductResponse;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import system.UtilityMethods;



public class ProductCreate extends Common {
    private static final String PATH = "\\src\\main\\resources\\ApiData\\Requests\\createProduct.txt";

   public String verifyAndReturnIdOfProductCreation() {
       String body = UtilityMethods.getJsonBodyFromFile(System.getProperty("user.dir") + PATH);
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
