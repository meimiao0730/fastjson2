package com.alibaba.fastjson2.primitves;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaderCreatorASM;
import com.alibaba.fastjson2.reader.ObjectReaders;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriterCreatorASM;
import com.alibaba.fastjson2.writer.ObjectWriters;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

public class StringValue_0 {
    public int MIN_VALUE = Byte.MIN_VALUE;
    public int MAX_VALUE = Byte.MAX_VALUE;
    @Test
    public void test_reflect() throws Exception {
        ObjectWriter<VO> ow = ObjectWriters.ofReflect(VO.class);
        ObjectReader<VO> oc = ObjectReaders.ofReflect(VO.class);

        for (int i = MIN_VALUE; i <= MAX_VALUE; ++i) {
            VO vo = new VO();
            vo.value = Integer.toString(i);
            JSONWriter w = JSONWriter.of();
            ow.write(w, vo);

            String json = w.toString();
            JSONReader jr = JSONReader.of(json);
            VO o = oc.readObject(jr, 0);
            assertEquals(vo.value, o.value);
        }
    }

    @Test
    public void test_lambda() throws Exception {
        ObjectWriter<VO> ow = ObjectWriters.objectWriter(VO.class);
        ObjectReader<VO> oc = ObjectReaders.of(VO.class);

        for (int i = MIN_VALUE; i <= MAX_VALUE; ++i) {
            VO vo = new VO();
            vo.value = Integer.toString(i);
            JSONWriter w = JSONWriter.of();
            ow.write(w, vo);

            String json = w.toString();
            JSONReader jr = JSONReader.of(json);
            VO o = oc.readObject(jr, 0);
            assertEquals(vo.value, o.value);
        }
    }

    @Test
    public void test_manual() throws Exception {
        ObjectWriter<VO> ow = ObjectWriters.objectWriter(ObjectWriters.fieldWriter("value", VO::getValue));
        ObjectReader<VO> oc = ObjectReaders.of(VO.class);

        for (int i = MIN_VALUE; i <= MAX_VALUE; ++i) {
            VO vo = new VO();
            vo.value = Integer.toString(i);
            JSONWriter w = JSONWriter.of();
            ow.write(w, vo);

            String json = w.toString();
            JSONReader jr = JSONReader.of(json);
            VO o = oc.readObject(jr, 0);
            assertEquals(vo.value, o.value);
        }
    }

    @Test
    public void test_asm() throws Exception {
        ObjectWriter<VO> ow = ObjectWriterCreatorASM.INSTANCE.createObjectWriter(VO.class);
        ObjectReader<VO> oc = ObjectReaderCreatorASM.INSTANCE.createObjectReader(VO.class);

        for (int i = MIN_VALUE; i <= MAX_VALUE; ++i) {
            VO vo = new VO();
            vo.value = Integer.toString(i);
            JSONWriter w = JSONWriter.of();
            ow.write(w, vo);

            String json = w.toString();
            JSONReader jr = JSONReader.of(json);
            VO o = oc.readObject(jr, 0);
            assertEquals(vo.value, o.value);
        }
    }


    public static class VO {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
