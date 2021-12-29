package cn.tianqb.common.exception;

/**
 * @author tianqingbo3
 * @version 1.0
 * @date 2021/12/20 14:31
 */
public class SystemException extends RuntimeException {
    private int code;

    public SystemException() {
        super();
    }

    public SystemException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    protected SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getCode() {
        return code;
    }

}
