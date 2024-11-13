package system;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.logging.Level;
import java.util.logging.Logger;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockBase {

    static WireMockServer wireMockServer = new WireMockServer(3333);
    private static final String wireMockMessage = "Wiremock works fine";


    public static void start() {
        wireMockServer.start();
        Logger.getAnonymousLogger().log(Level.INFO,"Wiremock is running on: " + wireMockServer.baseUrl());

    }

    public static void stop() {
        wireMockServer.stop();
    }

    public static void configureAnExample() {
        wireMockServer.stubFor(get(urlEqualTo("/vlatko?id=33"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(wireMockMessage)));
    }

    public static String getWireMockMessage() {
        return wireMockMessage;
    }
}
