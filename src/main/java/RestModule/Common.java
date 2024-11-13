package RestModule;

import enums.RestApiNames;
import enums.RestApiAuthTypes;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.UnsupportedEncodingException;
import java.util.*;


/**
 * Class for Common Actions for Rest Assure API
 */

public class Common {

    public static RequestSpecification spec;
    public static String url;
    private static RestApiNames restApi;
    private static RestApiAuthTypes restAuthTypes;

    public void setup() {

        String apiUrl;
        switch (getRestApiName()) {
            case TEST: {
                apiUrl = RestApiConstants.TEST_URL;
                break;
            }
            default:
                apiUrl = "";
        }
        spec = new RequestSpecBuilder()
                .setBaseUri(apiUrl)
                .build();
        // set RestAPI URL
        setRestApiUrl(apiUrl);
    }


    public static Map<String, Object> getAuthorizedHeader() {

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        switch (getRestApiAuth()) {
            case BASIC_AUTH:
                String valueToEncode = "user:password";
                String encodeString = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
                headerMap.put("Authorization", encodeString);
                break;
            case WITHOUT:
                System.out.println("No Authentication Required");
                break;

            case TOKEN_AUTH:
                headerMap.put("Authorization", getApiToken());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + getRestApiAuth());
        }

        return headerMap;
    }

    private static String getApiToken() {
        String token = null;
        switch (getRestApiName()) {
            case TEST: {
                token = RestApiConstants.TEST_TOKEN;
                break;
            }
        }
        return token;
    }

    public static void setRestApiName(RestApiNames rest) {
        restApi = rest;
    }

    public static void setRestApiAuthType(RestApiAuthTypes rest) {
        restAuthTypes = rest;
    }

    public static void setRestApiUrl(String apiUrl) {
        url = apiUrl;
    }

    public static RestApiNames getRestApiName() {
        return restApi;
    }

    public static String getRestApiUrl() {
        return url;
    }


    public static RestApiAuthTypes getRestApiAuth() {
        return restAuthTypes;
    }

    public static Response post(String body, String url) {
        RequestSpecification requestSpecification = RestAssured.given()
                .headers(getAuthorizedHeader())
                .when()
                .body(body);
        return requestSpecification.post(url);
    }


    public static Response get(String url) throws UnsupportedEncodingException {
        RequestSpecification requestSpecification = RestAssured.given()
                .headers(getAuthorizedHeader());
        return  requestSpecification.get(url);
    }

}
