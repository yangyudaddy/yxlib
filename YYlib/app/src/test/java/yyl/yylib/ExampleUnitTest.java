package yyl.yylib;

import org.junit.Test;

import yyl.testBean.TestBean;
import yyl.testData.TestData;
import yyl.utils.gson.Data;
import yyl.utils.gson.Result;

import static org.junit.Assert.assertEquals;
import static yyl.utils.gson.GsonUtils.fromJsonObject;
import static yyl.utils.gson.GsonUtils.toJsonString;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void gsonTest() throws Exception{
        Result<String> result= fromJsonObject(TestData.jsonData,String.class);
        assertEquals(result.getModel(),"reerererre");
       TestBean testBean = new TestBean();
        testBean.setName("yyl");
        testBean.setPwd("123456");
        Data data = Data.sendData(testBean);
        System.out.printf( toJsonString(data) );
    }

}