package com.alibaba.fastjson2.v1issues.issue_3600;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Issue3652 {
    @Test
    public void test_different_Class_Annotation() {
        Object[] models = new Object[]{
                new Model1("hello,world"),
                new Model2("hello,world"),
                new Model3("hello,world"),
                new Model4("hello,world"),
        };
        String[] JsonStrings = new String[]{
                "{\"goodBoy\":\"hello,world\"}",
                "{\"GoodBoy\":\"hello,world\"}",
                "{\"good_boy\":\"hello,world\"}",
                "{\"good-boy\":\"hello,world\"}"};
        /* PS: Order is
         CamelCase,
         PascalCase,
         SnakeCase,
         KebabCase,*/
        for (int i = 0; i < models.length; i++) {
            String[] toStrings = new String[PropertyNamingStrategy.values().length];
            toStrings[i] = JSON.toJSONString(models[i]);
            assertEquals(JsonStrings[i], toStrings[i]);
        }
    }

    @JSONType(naming = PropertyNamingStrategy.CamelCase)
    @Data
    @AllArgsConstructor
    public class Model1 {
        private String goodBoy;
    }

    @JSONType(naming = PropertyNamingStrategy.PascalCase)
    @Data
    @AllArgsConstructor
    public class Model2 {
        private String goodBoy;
    }

    @JSONType(naming = PropertyNamingStrategy.SnakeCase)
    @Data
    @AllArgsConstructor
    public class Model3 {
        private String goodBoy;
    }

    @JSONType(naming = PropertyNamingStrategy.KebabCase)
    @Data
    @AllArgsConstructor
    public class Model4 {
        private String goodBoy;
    }

}
