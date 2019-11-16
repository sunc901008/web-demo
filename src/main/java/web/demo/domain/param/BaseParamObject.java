package web.demo.domain.param;

import com.alibaba.fastjson.JSONObject;
import web.demo.base.NotBlank;
import web.demo.base.NotNull;
import web.demo.base.Size;
import web.demo.exception.BaseException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunc
 * @date 2019/11/16 16:19
 * @description BaseParamObject
 */

public abstract class BaseParamObject<T extends BaseParamObject> {

    public T init(String text, Class<T> clazz) throws BaseException {
        T obj = JSONObject.parseObject(text, clazz);
        obj.valid();
        return obj;
    }

    public void valid() throws BaseException {
        List<Field> list = new ArrayList<>(Arrays.asList(this.getClass().getDeclaredFields()));
        try {
            for (Field field : list) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                Object object = field.get(this);
                NotNull notNull = field.getAnnotation(NotNull.class);
                if (notNull != null) {
                    if (object == null) {
                        throw new BaseException(notNull.errCode(), notNull.message());
                    }
                }

                NotBlank notBlank = field.getAnnotation(NotBlank.class);
                if (notBlank != null) {
                    if (object == null || String.valueOf(object).trim().isEmpty()) {
                        throw new BaseException(notBlank.errCode(), notBlank.message());
                    }
                }

                Size size = field.getAnnotation(Size.class);
                if (size != null) {
                    if (object != null) {
                        int length = String.valueOf(object).trim().length();
                        if (length >= size.min() && length <= size.max()) {
                            continue;
                        }
                    }
                    throw new BaseException(size.errCode(), size.message());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
