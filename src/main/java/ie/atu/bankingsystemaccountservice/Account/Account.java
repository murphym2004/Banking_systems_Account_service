package ie.atu.bankingsystemaccountservice.Account;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "account")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String AccountName;
    private int AccountNumber;
    @Positive
    private double Balance;

    public Account(String accountName, int accountNumber, double balance) {
        AccountName = accountName;
        AccountNumber = accountNumber;
        Balance = balance;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

}
