package web.demo.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sunc
 * @date 2019/11/12 17:36
 * @description FocusValid
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Size {

    String message() default "invalid size";

    int min() default 0;

    int max() default 2147483647;

    int errCode() default 10000;

}
