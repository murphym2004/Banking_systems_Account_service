package ie.atu.bankingsystemaccountservice.Account.ErrorHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {
    private String fieldName;
    private String fieldValue;

    public ExceptionDetails(String fieldName, String message) {
        this.fieldName = fieldName;
        this.fieldValue = message;
    }
}