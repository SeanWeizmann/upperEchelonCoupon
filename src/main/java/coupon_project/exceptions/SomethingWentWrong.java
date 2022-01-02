package coupon_project.exceptions;

public class SomethingWentWrong extends RuntimeException{

    public SomethingWentWrong() {
        super();
    }

    public SomethingWentWrong(String message) {
        super(message);
    }

    public SomethingWentWrong(String message, Throwable cause) {
        super(message, cause);
    }

    public SomethingWentWrong(Throwable cause) {
        super(cause);
    }

    protected SomethingWentWrong(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
