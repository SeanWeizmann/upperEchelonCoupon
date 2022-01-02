package coupon_project.exceptions;

public class LoginException extends Exception {

    public LoginException() {
        super("General Error");
    }

    public LoginException(String message) {
        super(message);
    }


}
