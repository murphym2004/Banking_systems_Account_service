package ie.atu.bankingsystemaccountservice.Account.ErrorHandling;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        super(message);
    }
}