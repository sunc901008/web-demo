package web.demo.exception;

/**
 * 各种错误码定义
 *
 * @author sunc
 * @date 2019/11/18 8:39
 * @description ExceptionCode
 */

public class ExceptionCode {

    public static final int NAME_LENGTH_ERROR = BaseException.DEFAULT_ERROR + 1;
    public static final int NAME_NULL_ERROR = BaseException.DEFAULT_ERROR + 2;
    public static final int NAME_EXIST_ERROR = BaseException.DEFAULT_ERROR + 3;
    public static final int DESCRIPTION_LENGTH_ERROR = BaseException.DEFAULT_ERROR + 4;

}
