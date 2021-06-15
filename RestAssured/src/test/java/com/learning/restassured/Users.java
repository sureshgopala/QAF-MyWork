package com.learning.restassured;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
//plain old java object :: POJO
public class Users {

    public String name;
    public int id;
    public int publicRepo;

    public String getName() {
        return name;
    }
    @JsonProperty("public_repos")
    public int getPublicRepo(){
        return publicRepo;
    }
    public int getId() {
        return id;
    }
}
