package pl.seafta.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.seafta.persistance.account.AccountRequest;
import pl.seafta.service.RegistrationService;

@Controller
@RequestMapping("Account/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;


    @GetMapping
    public String registrationPage() {
        return "registration";
    }
    @PostMapping
    public String register(@RequestBody AccountRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {

        return registrationService.confirmToken(token);
    }
}
