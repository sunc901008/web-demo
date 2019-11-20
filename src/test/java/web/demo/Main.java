package web.demo;

import com.alibaba.fastjson.JSONObject;
import web.demo.domain.entity.TestInfo;

/**
 * @author sunc
 * @date 2019/11/19 18:29
 * @description Main
 */

public class Main {


    public static void main(String[] args) {
        TestInfo testInfo = new TestInfo().setAge(1).setName("abc");
        System.out.println(JSONObject.toJSONString(testInfo));

    }

}
