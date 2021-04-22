package pl.seafta.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.seafta.persistance.account.Account;
import pl.seafta.persistance.account.AccountRequest;
import pl.seafta.service.AccountService;

@RestController
@RequestMapping(path = "/Account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping("/register")
    public String register(@RequestBody AccountRequest request) {
        return accountService.register(request);
    }

}
