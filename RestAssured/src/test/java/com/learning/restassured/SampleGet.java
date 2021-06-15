package com.learning.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class SampleGet {

    @Test
    public void myReq(){
        RestAssured.get("https://api.github.com/")
                .then()
                .statusCode(200);
    }

    @Test
    public void myReq1(){
        RestAssured.get("https://api.github.com/").peek();
    }

    @Test
    public void myReq2(){
        RestAssured.get("https://api.github.com/").prettyPeek();
    }
    @Test
    public void myReq3(){
        RestAssured.get("https://api.github.com/").print();
    }

    @Test
    public void myReq4(){
        RestAssured.get("https://api.github.com/").prettyPrint();
    }
}
