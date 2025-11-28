package ie.atu.bankingsystemaccountservice.Account.ErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandling {

    // 400 – validation errors (return a list of {fieldName, fieldValue})
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDetails>> showErrorDetails(MethodArgumentNotValidException ex) {
        List<ExceptionDetails> errorList = new ArrayList<>();
        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            errorList.add(new ExceptionDetails(fe.getField(), fe.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }

    // 409 – duplicates (use your domain field, e.g. accountNumber)
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionDetails> duplicate(DuplicateException ex) {
        ExceptionDetails details = new ExceptionDetails("accountNumber", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(details);
    }

    // 404 – not found
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> notFound(NotFoundException ex) {
        ExceptionDetails details = new ExceptionDetails("resource", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
    }
}