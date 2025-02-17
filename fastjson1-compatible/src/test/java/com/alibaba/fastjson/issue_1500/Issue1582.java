package com.alibaba.fastjson.issue_1500;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertSame;

public class Issue1582 {
    @Test
    public void test_for_issue() throws Exception {
        assertSame(Size.Big, JSON.parseObject("\"Big\"", Size.class));
        assertSame(Size.Big, JSON.parseObject("\"big\"", Size.class));
        assertNull(JSON.parseObject("\"Large\"", Size.class));
        assertSame(Size.LL, JSON.parseObject("\"L3\"", Size.class));

        assertSame(Size.Small, JSON.parseObject("\"Little\"", Size.class));
    }

    @Test
    public void test_for_issue_1() throws Exception {
        JSONObject object = JSON.parseObject("{\"size\":\"Little\"}");
        Model model = object.toJavaObject(Model.class);
        assertSame(Size.Small, model.size);
    }

    public static class Model {
        public Size size;
    }

    public static enum Size {
        Big,

        @JSONField(alternateNames = "Little")
        Small,

        @JSONField(name = "L3")
        LL
    }
}
