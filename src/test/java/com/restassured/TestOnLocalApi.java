package com.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class TestOnLocalApi {

    //@Test
    public void get(){

        baseURI = "http://localhost:3000/";

        given().
            get("users").
        then().
            statusCode(200).log().all();



    }

    @Test
    public void post(){

        JSONObject request = new JSONObject();

        request.put("firstName", "Deepak");
        request.put("lastName", "Verma");
        request.put("SubjectId", 1);

        baseURI = "http://localhost:3000/";

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("users").
            then().statusCode(201).log().all();
    }

    @Test
    public void put(){

        JSONObject request = new JSONObject();

        request.put("firstName", "Monty");
        request.put("lastName", "Verma");
        request.put("SubjectId", 2);

        baseURI = "http://localhost:3000/";

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            put("users/4950").
            then().statusCode(200).log().all();
    }

    @Test
    public void patch(){

        JSONObject request = new JSONObject();

       
        request.put("lastName", "Nath");
       

        baseURI = "http://localhost:3000/";

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            patch("users/1").
            then().statusCode(200).log().all();
    }

    @Test
    public void delete(){

        baseURI = "http://localhost:3000/";

       
        when().
            delete("users/3").
            then().statusCode(200).log().all();
    }

}
