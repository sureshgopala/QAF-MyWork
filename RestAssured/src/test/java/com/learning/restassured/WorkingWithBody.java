package com.learning.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

public class WorkingWithBody {

    public static String url = "https://api.github.com/rate_limit";


    @Test
    public void myBody(){
        Response response = RestAssured.get(url);
        ResponseBody bd = response.body();

        JsonPath jsonPath = bd.jsonPath();
        JsonPath jsonPath1 = response.body().jsonPath();

        Map<String, String> map1 = jsonPath1.get();
        Map<String, String> map2 = jsonPath1.get("resources");
        Map<String, String> map3 = jsonPath1.get("resources.core");
        int value = jsonPath1.get("resources.core.limit");

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(value);

    }

    @Test
    public void myBody2(){
        RestAssured.get(url+"users/andrejs-ps")
                .then()
                .body("url", response -> Matchers.containsString(response.body().jsonPath().get("login")));

    }

    @Test
    public void myBody3(){
        RestAssured.get(url)
                .then()
                .rootPath("resources.core")
                    .body("limit", Matchers.equalTo(60))
                    .body("remaining", Matchers.lessThanOrEqualTo(60))
                    .body("reset", Matchers.notNullValue())
                .rootPath("resources.search")
                    .body("limit", Matchers.equalTo(60))
                    .body("remaining", Matchers.lessThanOrEqualTo(60))
                .noRootPath()
                    .body("resources.core.limit", Matchers.equalTo(60));



    }

}
