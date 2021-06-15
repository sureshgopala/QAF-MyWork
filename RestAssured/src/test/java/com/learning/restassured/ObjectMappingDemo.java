package com.learning.restassured;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObjectMappingDemo {

    public static String uri = "https://api.github.com/users/rest-assured";

    @Test
    public void myDemo(){
       Users user = RestAssured.get(uri)
               .as(Users.class);
        Assert.assertEquals(user.getId(), 19369327);
        Assert.assertEquals(user.getName(), "REST Assured");
        Assert.assertEquals(user.getPublicRepo(), 2);
    }

}
