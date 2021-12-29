package cn.tianqb.common.utils;

public class WebResult<T> {

    private Integer code;

    private T data;

    private String msg;

    public WebResult() {

    }

    public WebResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WebResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> WebResult<T> success(T result) {
        return new WebResult<>(200, "success", result);
    }

    public static WebResult error(Integer code, String msg) {
        return new WebResult<>(code, msg, null);
    }

}
