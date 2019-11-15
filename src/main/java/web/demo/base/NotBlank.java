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
public @interface NotBlank {

    String message() default "field blank";

    int errCode() default 10000;

}
