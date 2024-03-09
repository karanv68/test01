package com.restassured;

import org.apache.commons.io.IOUtils;
import org.apache.maven.shared.utils.io.IOUtil;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoapXmlRequest {

    @Test
    public void validateSoapXml() throws IOException{

        File file = new File("./SoapRequest/soaprequest.xml");

        if(file.exists()){
            System.out.println(">> File Exists >>");
        }

        FileInputStream file1 = new FileInputStream(file);
        String requestBody = IOUtils.toString(file1, "UTF-8");

        baseURI = "https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService/";

        given(). 
            contentType("text/xml").
            accept(ContentType.XML).
            // header("Accept","text/xml").
            body(requestBody).
        when(). 
            post("Calc.asmx?op=Add").
        then().
            statusCode(200).log().all();
    }

}
