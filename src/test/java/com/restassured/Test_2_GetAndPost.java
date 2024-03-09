package com.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*; // when we use this we don't need to give RestAssured everytime directly give the function
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Test_2_GetAndPost {

    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api";

        given().
            get("/users?page=2").
        then().
            statusCode(200).
            body("data[0].first_name", equalTo("Michael")).
            body("data.first_name",hasItems("Lindsay","Tobias"));

    }

    @Test
    public void testPost(){

        Map<String,Object> map = new HashMap<String,Object>();

        // map.put("name", "Karan");
        // map.put("job", "Teacher");
        // System.out.println(map);
        // JSONObject request = new JSONObject(map);


        JSONObject request = new JSONObject();
        request.put("name", "Karan");
        request.put("job","Teacher");

        System.out.println(request.toJSONString());

    }

    @Test
    public void testGetAndPost(){

        JSONObject request1 = new JSONObject();
        request1.put("name", "Karan");
        request1.put("job","Engineer");

        baseURI = "https://reqres.in/api";

        given().
         body(request1.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).log().all();

        
    }

}
