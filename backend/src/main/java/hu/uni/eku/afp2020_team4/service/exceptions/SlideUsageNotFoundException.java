package hu.uni.eku.afp2020_team4.service.exceptions;

public class SlideUsageNotFoundException extends Exception {
    public SlideUsageNotFoundException() {
    }

    public SlideUsageNotFoundException(String message) {
        super(message);
    }

    public SlideUsageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SlideUsageNotFoundException(Throwable cause) {
        super(cause);
    }

    public SlideUsageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}