package ie.atu.bankingsystemaccountservice.Account;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accountlist")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccountlist(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Long id){
        Account account = accountService.findById(id);
        if(account != null){
            return ResponseEntity.ok(account); // HTTP 200
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 if not found
        }
    }

    @PostMapping("AddAccount")
    public Account create(@Valid @RequestBody Account account){
        return accountService.create(account);
    }

    @DeleteMapping("DeleteAccount/{id}")
    public void delete(@PathVariable("id") Long id){
        accountService.delete(id);
    }


    @PutMapping("updateAccount")
    public Account update(@Valid @RequestBody Account account) {
        return accountService.update(account);

    }


}

