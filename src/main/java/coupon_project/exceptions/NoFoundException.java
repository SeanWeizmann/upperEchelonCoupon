package coupon_project.exceptions;

public class NoFoundException extends Exception{

    public NoFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFoundException(Throwable cause) {
        super(cause);
    }

    protected NoFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NoFoundException() {
        super();
    }

    public NoFoundException(String message) {
        super(message);
    }
}
