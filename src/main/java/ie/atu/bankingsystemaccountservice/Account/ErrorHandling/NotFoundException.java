package ie.atu.bankingsystemaccountservice.Account.ErrorHandling;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
