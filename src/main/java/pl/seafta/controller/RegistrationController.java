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


    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("request", new AccountRequest());
        return "registration";
    }


    @PostMapping("/registration")
    public String register(@ModelAttribute(value ="request") AccountRequest request) {
        System.out.println(request.getPassword() + "elo");
        registrationService.register(request);
        return "redirect:/login";
    }

    @GetMapping(path = "registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}

