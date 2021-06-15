package com.learning.restassured;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

public class Marshalling {


    public static String uri = "https://api.github.com/users/rest-assured";

    @Test
    public static void wrapperOM() {
        io.restassured.mapper.ObjectMapper mapper = new Jackson2Mapper(new Jackson2ObjectMapperFactory() {
            @Override
            public ObjectMapper create(Type cls, String charset) {
                ObjectMapper om = new ObjectMapper();
                om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return om;
            }
        });
        RestAssured.get(uri)
                .as(AnotherUsers.class, mapper);
    }


    }


