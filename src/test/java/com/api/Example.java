package com.api;

import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class Example extends TestBase {

    private final String BASE_URL = "https://graph.facebook.com/" ;
    private final String page_id = "400380214089147";

   @Test
   public void testRequest(){
       ValidatableResponse validatableResponse;
       Map<String, String> requestBody = new HashMap<>();
       requestBody.put("message" , "WOWOWO");
       requestBody.put("access_token" ,
               "EAAEi4TqZCU5ABAAkHNoIGdzkqqB2JJJZAZCiYtiVpn3P1mOYIAChfHV4Fvol73uSXSv312McV1pM65xMiJQ7eZBBkOOUnvAR1ldjxYLlWQ9WRQdKHMZC3yWPsUR3H6SRteijouj7baEtZAp717AFjKKchwV9aH0fPlxylEVZCVxM6oS38LvyYZC502s7R5DItaZBoP7zwPmevYgZDZD");
       String finalURL = BASE_URL+page_id+"/feed";

       validatableResponse = sendPostRequest(requestBody,finalURL);

        //this is just an example
       int id = validatableResponse.extract().body().jsonPath().get("id");
       Assert.assertEquals(id , 11111);
   }



}


