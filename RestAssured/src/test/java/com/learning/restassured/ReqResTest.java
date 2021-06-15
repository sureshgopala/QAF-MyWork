package com.learning.restassured;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReqResTest {

    public static String url = "https://reqres.in/api/users?page=2";
    List<String> emails;

    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
    }

    @Test
    public void testBody() {

        List<Map> lst = RestAssured.get(url)
                .getBody()
                .jsonPath()
                .getList("data");
        System.out.println(lst);
        for(Map subMaps: lst){
            if(subMaps.containsKey("email")) {
                emails = new ArrayList<String>();
                emails.add(subMaps.get("email").toString());
                System.out.println(emails);
            }
        }
        Assert.assertFalse(emails.contains("michael.lawson@reqres.in"));

    }
        @Test
        public void testInt() {

            int per_page = RestAssured.get(url)
                    .getBody()
                    .jsonPath().getInt("per_page");

            Assert.assertEquals(per_page, 6);

        }

    @Test
    public void testGlobal() {

        RestAssured.given().
                header("G-TOKEN", "ROM831ESV")
                .auth().none()
                .get("http://localhost:8080/books").prettyPrint();

    }
        @Test
    public void testJsonPath(){
        String expVal = RestAssured.get(url)
                .getBody()
                .jsonPath().getString("data.email[2]");
            System.out.println(expVal);

        Assert.assertTrue(expVal.equalsIgnoreCase("tobias.funke@reqres.in"));


    }

    @Test
    public void testBasicAuth(){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("id", "123");
        headers.put("first_name", "Suresh");
        headers.put("last_name", "Gopala");
        headers.put("email", "sureshgnie@gmail.com");
        headers.put("Authorization", "token"+"abcdedhf");


    }

    @Test
    public void testUI(){
       // System.setProperty("webdriver.chrome.driver", "servers/chromedriver");
       // WebDriver driver = new ChromeDriver();
        WebDriver driver = new SafariDriver();
        driver.navigate().to("https://wellsfargo.com");
        driver.close();
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
    }

}
