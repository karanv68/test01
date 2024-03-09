
package com.restassured;

import org.junit.Assert;
import org.testng.annotations.Test;

// import io.restassured.RestAssured; // working normally
import static io.restassured.RestAssured.*; // when we use this we don't need to give RestAssured everytime directly give the function
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Test_1 {

    @Test
    public void test_1() {

        Response response = get("https://reqres.in/api/users?page=2"); // getting the response from api
        // RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode()); // this will give the status code
        System.out.println(response.getTime()); // this will print the time of execution in mili secs.
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.getStatusCode();

        // adding assertions
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void Test_2(){

        baseURI = "https://reqres.in/api";

        // bdd framework.
        given().
            get("/users?page=2").
                then().
                    statusCode(200).
                    body("data[1].id",equalTo(8)).
                        log().all();


    }

}
