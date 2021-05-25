package pl.seafta.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.seafta.persistance.account.AccountRequest;
import pl.seafta.service.RegistrationService;

@Controller
@RequestMapping
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;


    @GetMapping("registration")
    public String registrationPage(Model model) {
        return "registration";
    }


    @PostMapping("registration")
    public String register(@RequestBody AccountRequest request) {
        registrationService.register(request);
        return "registration";
    }

    @GetMapping(path = "registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}

