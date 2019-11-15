package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:37
 * @description NameException
 */

public class NameException extends BaseException {

    public NameException(String msg) {
        super(msg);
        this.errCode = this.errCode + 1;
    }

}
