package com.alibaba.fastjson2.primitves;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriterCreator;
import com.alibaba.fastjson2.writer.ObjectWriterCreatorASM;
import com.alibaba.fastjson2.writer.ObjectWriterCreatorLambda;
import com.alibaba.fastjson2_vo.IntegerField1;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

public class IntegerFieldTest {
    @Test
    public void test_arrayMapping() {
        ObjectWriterCreator[] creators = new ObjectWriterCreator[] {
                ObjectWriterCreator.INSTANCE,
                ObjectWriterCreatorLambda.INSTANCE,
                ObjectWriterCreatorASM.INSTANCE
        };

        for (ObjectWriterCreator creator : creators) {
            ObjectWriter<IntegerField1> objectWriter = creator.createObjectWriter(IntegerField1.class);

            {
                IntegerField1 vo = new IntegerField1();
                vo.v0000 = 1;
                JSONWriter jsonWriter = JSONWriter.of();
                objectWriter.write(jsonWriter, vo);
                assertEquals("{\"v0000\":1}", jsonWriter.toString());
            }
            {
                IntegerField1 vo = new IntegerField1();
                JSONWriter jsonWriter = JSONWriter.of();
                objectWriter.write(jsonWriter, vo);
                assertEquals("{}", jsonWriter.toString());
            }
            {
                IntegerField1 vo = new IntegerField1();
                vo.v0000 = 1;
                JSONWriter jsonWriter = JSONWriter.ofUTF8();
                objectWriter.write(jsonWriter, vo);
                assertEquals("{\"v0000\":1}", jsonWriter.toString());
            }
            {
                IntegerField1 vo = new IntegerField1();
                JSONWriter jsonWriter = JSONWriter.ofUTF8();
                objectWriter.write(jsonWriter, vo);
                assertEquals("{}", jsonWriter.toString());
            }
            {
                IntegerField1 vo = new IntegerField1();
                JSONWriter jsonWriter = JSONWriter.of();
                jsonWriter.config(JSONWriter.Feature.WriteNulls);
                objectWriter.write(jsonWriter, vo);
                assertEquals("{\"v0000\":null}", jsonWriter.toString());
            }
            {
                IntegerField1 vo = new IntegerField1();
                vo.v0000 = 1;
                JSONWriter jsonWriter = JSONWriter.of();
                jsonWriter.config(JSONWriter.Feature.BeanToArray);
                objectWriter.write(jsonWriter, vo);
                assertEquals("[1]", jsonWriter.toString());
            }
            {
                IntegerField1 vo = new IntegerField1();
                JSONWriter jsonWriter = JSONWriter.of();
                jsonWriter.config(JSONWriter.Feature.BeanToArray);
                objectWriter.write(jsonWriter, vo);
                assertEquals("[null]", jsonWriter.toString());
            }
        }
    }
}
