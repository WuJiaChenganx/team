package teamWeb.utils;

public class APIResponse<T> {

    private static final String CODE_SUCCESS = "200";

    private static final String CODE_FAIL = "500";

    private String code;
    private T data;
    private String msg;

    public APIResponse() {

    }

    public APIResponse(String code) {
        this.code = code;
    }

    public APIResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public APIResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static teamWeb.utils.APIResponse success() {
        return new teamWeb.utils.APIResponse(CODE_SUCCESS);
    }

    public static teamWeb.utils.APIResponse success(Object data) {
        return new teamWeb.utils.APIResponse(CODE_SUCCESS, data);
    }

    public static teamWeb.utils.APIResponse fail(String msg) {
        return new teamWeb.utils.APIResponse(CODE_FAIL, msg);
    }

    public static teamWeb.utils.APIResponse widthCode(String errorCode) {
        return new teamWeb.utils.APIResponse(errorCode);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

