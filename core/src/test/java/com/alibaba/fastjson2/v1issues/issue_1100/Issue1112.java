package com.alibaba.fastjson2.v1issues.issue_1100;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPath;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by wenshao on 01/04/2017.
 */
public class Issue1112 {
    @Test
    public void test_for_issue_1() throws Exception {
        JSONObject object = new JSONObject();
        object.put("123", "abc");

        assertEquals("abc", JSONPath.eval(object, "$.123"));
    }

    @Test
    public void test_for_issue_2() throws Exception {
        JSONObject object = new JSONObject();
        object.put("345_xiu", "abc");

        assertEquals("abc", JSONPath.eval(object, "$.345_xiu"));
    }

    @Test
    public void test_for_issue_3() throws Exception {
        JSONObject object = new JSONObject();
        object.put("345.xiu", "abc");

        assertEquals("abc", JSONPath.eval(object, "$.345\\.xiu"));
    }
}
