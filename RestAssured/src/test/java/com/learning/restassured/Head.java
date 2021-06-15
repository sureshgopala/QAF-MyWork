package com.learning.restassured;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Head {

    public static String url = "https://api.github.com/";

    @Test
    public void workHead() {
        RestAssured.options(url)
                .then()
                .statusCode(204)
                .headers("access-control-allow-methods", Matchers.equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(Matchers.emptyOrNullString());
    }


    @Test
    public void workHead2() {
        RestAssured.head(url)
                .then()
                .statusCode(200)
                .body(Matchers.emptyOrNullString());
    }
}
