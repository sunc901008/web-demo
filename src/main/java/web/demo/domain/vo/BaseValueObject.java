package web.demo.domain.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author sunc
 * @date 2019/11/15 18:29
 * @description BaseParamObject
 */

public abstract class BaseValueObject {

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue);
    }

}
