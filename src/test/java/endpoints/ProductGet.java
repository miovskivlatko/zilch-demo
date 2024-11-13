package endpoints;

import RestModule.Common;
import io.restassured.response.Response;


import java.io.UnsupportedEncodingException;


public class ProductGet extends Common {

    public int getResponseCodeOnGetProduct(String id) throws UnsupportedEncodingException {

        String buildUrl = getRestApiUrl() + "?id=" + id;
        Response response = get(buildUrl);

        return response.getStatusCode();
    }

}
