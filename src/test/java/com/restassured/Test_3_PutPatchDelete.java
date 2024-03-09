package com.restassured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*; // when we use this we don't need to give RestAssured everytime directly give the function

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class Test_3_PutPatchDelete {

    @Test
    public void testPut(){

    

    JSONObject request1 = new JSONObject();
    request1.put("name", "Karan");
    request1.put("job","Engineer");

    baseURI = "https://reqres.in/api";

    given().
    header("Content-Type","application").
    contentType(ContentType.JSON).
    body(request1.toJSONString()).
    when().
        put("users/2").
    then().
        statusCode(200).
        log().all();

}

@Test
    public void testPatch(){

    JSONObject request1 = new JSONObject();
    request1.put("name", "Karan");
    request1.put("job","Engineer");

    baseURI = "https://reqres.in/";

    given().
    header("Content-Type","application").
    contentType(ContentType.JSON).
    body(request1.toJSONString()).
    when().
        patch("api/users/2").
    then().
        statusCode(200).
        log().all();

}

@Test
    public void testDelete(){

   
    baseURI = "https://reqres.in/";

    when().
        delete("api/users/2").
    then().
        statusCode(204).
        log().all();

}
}
