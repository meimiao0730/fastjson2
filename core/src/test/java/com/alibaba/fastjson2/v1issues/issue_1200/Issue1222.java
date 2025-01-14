package com.alibaba.fastjson2.v1issues.issue_1200;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by wenshao on 01/06/2017.
 */
public class Issue1222 {
    @Test
    public void test_for_issue() throws Exception {
        Model model = new Model();
        model.type = Type.A;
        String text = JSON.toJSONString(model, JSONWriter.Feature.WriteEnumUsingToString);
        assertEquals("{\"type\":\"TypeA\"}", text);
    }

    public static class Model {
        public Type type;
    }

    public static enum Type {
        A, B;

        public String toString() {
            return "Type" + this.name();
        }
    }
}
