package com.alibaba.fastjson2.codec;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

public class PrivateClassTest {
    @Test
    public void test_for_issue() throws Exception {
        String json = "{\"ab\":123,\"a_b\":456}";
        TestBean tb = JSON.parseObject(json, TestBean.class);
        assertEquals(123, tb.getAb());
    }

    private static class TestBean {
        private int ab;

        public int getAb() {
            return ab;
        }

        public void setAb(int ab) {
            this.ab = ab;
        }
    }
}
