package blog.ordincode.common.response;

public class CustomResponse<T> {
    private T data;
    private boolean isOk;
    private String code;
    private String message;

    public CustomResponse(final T data, boolean isOk, final String code, final String message) {
        this.data = data;
        this.isOk = isOk;
        this.code = code;
        this.message = message;
    }

    public static <Void> CustomResponse<Void> empty() {
        return new CustomResponse<>(null, true, null, null);
    }

    public static <Void> CustomResponse<Void> error(String message) {
        return new CustomResponse<>(null, false, null, message);
    }

    public static <T> CustomResponse<T> of(T data) {
        return new CustomResponse<>(data, true, null, null);
    }

    public static <T> CustomResponse<T> of(T data, String code) {
        return new CustomResponse<>(data, true, code, null);
    }

    public T getData() {
        return data;
    }

    public boolean isOk() {
        return isOk;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
