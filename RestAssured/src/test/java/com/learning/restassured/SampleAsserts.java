package com.learning.restassured;

import com.google.common.collect.Ordering;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.number.OrderingComparison;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SampleAsserts {

    public static String url = "https://api.github.com/";

    @Test
    public void myReq5(){

      Response response = RestAssured.get(url);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Headers headers = response.getHeaders();
        int size = headers.size();
        boolean isPresent = headers.hasHeaderWithName("contentType");
        Assert.assertFalse(isPresent);
        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

}

    @Test
    public void basicValidateResponse(){
        RestAssured.get(url)
                .then()
                .statusCode(200)
                .statusCode(Matchers.lessThan(300))
                .contentType(ContentType.JSON)
                .headers("x-ratelimit-limit","60")
                .time(Matchers.lessThan(4L), TimeUnit.SECONDS)
                .header("etag", Matchers.notNullValue())
                .header("etag", Matchers.not(Matchers.emptyString()))
        //Advanced Matchers
                .header("etag", Integer::parseInt, Matchers.equalTo(60) )
                .header("date", date-> LocalDate.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME),
                        OrderingComparison.comparesEqualTo(LocalDate.now()))
                .header("x-ratelimit-limit", response -> Matchers.greaterThan(response.header("x-ratelimit-remaining")));


    }

    @Test
    public void withMap(){

        Map<String, String> map = Map.of("content-encoding", "gzip","server", "GitHub.com");

        RestAssured.get(url)
                .then()
                .headers(map);
    }

}
