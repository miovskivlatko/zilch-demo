package endpoints;

import RestModule.Common;
import io.restassured.response.Response;

import java.io.UnsupportedEncodingException;

import static RestModule.Common.getRestApiUrl;

public class WireMockEndpoint {

    public String getResponseForWireMockedCall() throws UnsupportedEncodingException {

        String buildUrl = "http://127.0.0.1:3333/vlatko?id=33";
        Response response = Common.get(buildUrl);

        return response.getBody().asString();
    }
}
