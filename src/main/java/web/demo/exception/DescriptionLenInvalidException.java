package web.demo.exception;

/**
 * @author sunc
 * @date 2019/11/10 9:37
 * @description NameException
 */

public class DescriptionLenInvalidException extends BaseException {

    public DescriptionLenInvalidException(String msg) {
        super(msg);
        this.errCode = ExceptionCode.DESCRIPTION_LENGTH_ERROR;
    }

}
