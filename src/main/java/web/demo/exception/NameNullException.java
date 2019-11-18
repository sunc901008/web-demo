package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:37
 * @description NameException
 */

public class NameNullException extends BaseException {

    public NameNullException(String msg) {
        super(msg);
        this.errCode = ExceptionCode.NAME_NULL_ERROR;
    }

}
