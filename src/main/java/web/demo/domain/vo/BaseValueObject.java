package web.demo.domain.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author sunc
 * @date 2019/11/15 18:29
 * @description BaseParamObject
 */

public abstract class BaseValueObject {

    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue);
    }

}
