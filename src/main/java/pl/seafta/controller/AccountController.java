package pl.seafta.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping
@AllArgsConstructor
public class AccountController {

    @GetMapping("account")
    public String accountPage(Model model) {
        return "account";
    }

}
