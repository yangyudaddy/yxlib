package yyl.utils.gson;


/**
 * ——感觉自己萌萌哒——
 * +   /\_/\     +
 * + =( °w° )=   +
 * +   )   (  // +
 * + (__ __)//   +
 * +++++++++++++++
 * <p>
 * author: yangxiaoling
 * Create_Date:   2018/2/9 下午3:05
 * Package_NAME  yyl.utils
 * Describe:
 */

public class Result<T> {
    private String code;
    private String message;
    private T model;
    private boolean isSuccess;

    public Result(String code,String message,T model){
        this.code = code;
        this.message = message;
        this.model = model;
    }

    public static <T> Result<T> success(T modle){
        return new Result("","",modle);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
