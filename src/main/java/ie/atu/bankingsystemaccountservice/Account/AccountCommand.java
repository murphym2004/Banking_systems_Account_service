package ie.atu.bankingsystemaccountservice.Account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountCommand implements CommandLineRunner {
    private final AccountRepository accountRepository;
    public AccountCommand(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Account account1 = new Account("matthew",16782,7642.10);
        Account account2 = new Account("john",12522,6642.10);
        Account account3 = new Account("David",51853,87642.10);
        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);

    }
}
