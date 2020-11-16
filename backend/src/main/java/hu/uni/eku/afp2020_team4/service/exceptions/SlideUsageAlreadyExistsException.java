package hu.uni.eku.afp2020_team4.service.exceptions;

public class SlideUsageAlreadyExistsException extends Exception {
    public SlideUsageAlreadyExistsException() {
    }

    public SlideUsageAlreadyExistsException(String message) {
        super(message);
    }

    public SlideUsageAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SlideUsageAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public SlideUsageAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}