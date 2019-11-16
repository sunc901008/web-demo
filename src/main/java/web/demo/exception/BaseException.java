package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:36
 * @description BaseException
 */

public class BaseException extends Exception {
    static final int DEFAULT_ERROR = 10000;
    public String message;
    public int errCode;
    public Object promptMsg;
    public Object msgParams;

    public BaseException(int errCode, String msg) {
        super(msg);
        this.message = msg;
        this.errCode = errCode;
    }

    public BaseException(String msg) {
        super(msg);
        this.message = msg;
        this.errCode = DEFAULT_ERROR;
    }

    public BaseException(String msg, Object msgParams) {
        super(msg);
        this.message = msg;
        this.msgParams = msgParams;
        this.errCode = DEFAULT_ERROR;
    }

}
