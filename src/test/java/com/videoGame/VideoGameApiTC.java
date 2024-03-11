package com.videoGame;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

public class VideoGameApiTC {

    // Get request : To get the data from an API

    @Test
    public void test_getAllVideoGames(){

        baseURI = "http://localhost:8080/app";

        given().
        when().
            get("/videogames").
        then().
            statusCode(200)
        .log().all();

    }

    // Post Request = To add a new data in the API

    @Test
    public void test_put_addNewVideoGame(){

        baseURI = "http://localhost:8080/app";

        // HashMap data = new HashMap<>();

        // data.put("id","100");
        // data.put("name","Pink-Panther");
        // data.put("release-date","2024-03-11T16:21:43.283Z");
        // data.put("reviewScore","5");
        // data.put("category","Adventure");
        // data.put("rating","Universal");


        // Response res =         
        // given().
        //     contentType("application.json").
        //     body(data).
        // when().
        //     post("/videogames").
        // then().
        //     statusCode(200)
        // .log().body().extract().response();

        // String jsonString = res.asString();
        // System.out.println(jsonString);

        // Assert.assertEquals(jsonString.contains("Record Added Successfully"), true);

        JSONObject requestBody = new JSONObject();
        requestBody.put("id","100");
        requestBody.put("name","Pink-Panther");
        requestBody.put("release-date","2024-03-11T16:21:43.283Z");
        requestBody.put("reviewScore","5");
        requestBody.put("category","Adventure");
        requestBody.put("rating","Universal");

        Response res =      
        given(). 
            contentType("application/json").
            body(requestBody.toJSONString()).
       when().
           post("/videogames").
       then(). 
            statusCode(200)
            .log().body().extract().response();

            String jsonString = res.asString();

            Assert.assertEquals(jsonString.contains("Record Added Successfully"), true);
    }

    // GET request - getting  the data from api


    @Test
    public void test_Get_Game(){

        baseURI = "http://localhost:8080/app";

        given().
        when().
            get("/videogames/100").
        then().
            statusCode(200).body("videoGAme.id", equalTo("100"))
            .body("videoGame.name", equalTo("Pink-Panther")).log().body();

    }
}
