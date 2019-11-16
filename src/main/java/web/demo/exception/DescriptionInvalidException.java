package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:37
 * @description NameException
 */

public class DescriptionInvalidException extends BaseException {
    public static final int ERROR_CODE = BaseException.DEFAULT_ERROR + 2;

    public DescriptionInvalidException(String msg) {
        super(msg);
        this.errCode = ERROR_CODE;
    }

}
