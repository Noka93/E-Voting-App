package semicolon.africa.votersApp.exceptions;

public class VoterRegistrationException extends Exception{


    public VoterRegistrationException() {
        super();
    }

    public VoterRegistrationException(String message) {
        super(message);
    }

    public VoterRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoterRegistrationException(Throwable cause) {
        super(cause);
    }

    protected VoterRegistrationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
