package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:37
 * @description NameException
 */

public class NameInvalidException extends BaseException {
    public static final int ERROR_CODE = BaseException.DEFAULT_ERROR + 1;

    public NameInvalidException(String msg) {
        super(msg);
        this.errCode = ERROR_CODE;
    }

}
