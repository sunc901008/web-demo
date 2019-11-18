package web.demo.exception;

/**
 * 各种错误码定义
 *
 * @author sunc
 * @date 2019/11/18 8:39
 * @description ExceptionCode
 */

public class ExceptionCode {

    /**
     * 参数基础校验类错误码 10001~10100 如表名不能为空, 描述长度不合法等等
     */
    public static final int NOT_DEFINE_ERROR = BaseException.DEFAULT_ERROR + 1;
    public static final int NAME_LENGTH_ERROR = BaseException.DEFAULT_ERROR + 2;
    public static final int NAME_NULL_ERROR = BaseException.DEFAULT_ERROR + 3;
    public static final int DESCRIPTION_LENGTH_ERROR = BaseException.DEFAULT_ERROR + 4;

    /**
     * 业务校验类错误码 10101~11000 如表名已存在, 用户不存在, 无权限等等
     */
    public static final int NAME_EXIST_ERROR = BaseException.DEFAULT_ERROR + 101;

    public static void createException(int errCode, String msg) throws NotDefineException, NameLenInvalidException, NameNullException, DescriptionLenInvalidException {
        switch (errCode) {
            case NAME_LENGTH_ERROR:
                throw new NameLenInvalidException(msg);
            case NAME_NULL_ERROR:
                throw new NameNullException(msg);
            case DESCRIPTION_LENGTH_ERROR:
                throw new DescriptionLenInvalidException(msg);
            default:
                throw new NotDefineException(msg);
        }
    }

}
