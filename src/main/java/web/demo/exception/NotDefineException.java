package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:37
 * @description NameException
 */

public class NotDefineException extends BaseException {

    public NotDefineException(String msg) {
        super(msg);
        this.errCode = ExceptionCode.NOT_DEFINE_ERROR;
    }

}
