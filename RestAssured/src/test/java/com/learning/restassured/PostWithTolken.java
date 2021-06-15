package com.learning.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostWithTolken {

    public static String token = "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";
    public static String url = "https://api.github.com/user/repos";
    public static String url_patch = "https://api.github.com/repos/sureshgopala/deleteme";
    public static String url_delete = "https://api.github.com/repos/sureshgopala/deleteme-patched";

    @Test(description = "Create a Test")
    public void postTest(){
        RestAssured.given()
                .header("Authorization", "token " + token)
                .body("{\"name\":\"deleteme\"}")
                .when()
                .post(url)
                .then()
                .statusCode(201);

    }
    @Test(description = "Create a Patch")
    public void patchTest(){
        RestAssured.given()
                .header("Authorization", "token " + token)
                .body("{\"name\":\"deleteme-patched\"}")
                .when()
                .patch(url_patch)
                .then()
                .statusCode(200);

    }
    @Test(description = "Create a Delete", dependsOnMethods = "postTest")
    public void deleteTest(){
        RestAssured.given()
                .header("Authorization", "token " + token)
                .when()
                .delete(url_delete)
                .then()
                .statusCode(204);

    }
}
