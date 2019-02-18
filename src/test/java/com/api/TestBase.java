package com.api;

import io.restassured.response.ValidatableResponse;
import sun.security.util.PendingException;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestBase {

    protected ValidatableResponse sendPostRequest(Map<String, String> body , String url) throws PendingException {
        ValidatableResponse response;

        response = given().contentType("application/json").body(body).post(url).then();

        if (response.extract().response().getStatusCode() > 299) {
            throw new PendingException(
                    "POST request is not successful: " + "Status:" + response.extract().response().getStatusCode() + " Body: " + response.extract().body()
                            .asString());
        }
        return response;
    }

    protected ValidatableResponse sendGetRequest(Map<String, String> body, String url) throws PendingException {
        ValidatableResponse response;

        if (body == null) {
            response = given().contentType("application/json").get(url).then();
        } else {
            response = given().contentType("application/json").body(body).get(url).then();
        }
        if (response.extract().response().getStatusCode() > 299) {
            throw new PendingException(
                    "GET request is not successful: " + "Status:" + response.extract().response().getStatusCode() + " Body: " + response.extract().body()
                            .asString());
        }
        return response;
    }
}
