package web.demo.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author sunc
 * @date 2019/11/10 20:24
 * @description Commons
 */

public class Commons {

    public static String toJsonString(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue);
    }

}
