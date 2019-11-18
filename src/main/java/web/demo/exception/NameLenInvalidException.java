package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:37
 * @description NameException
 */

public class NameLenInvalidException extends BaseException {

    public NameLenInvalidException(String msg) {
        super(msg);
        this.errCode = ExceptionCode.NAME_LENGTH_ERROR;
    }

}
