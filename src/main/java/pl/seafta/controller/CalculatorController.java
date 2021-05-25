package pl.seafta.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.seafta.persistance.account.AccountDetails;
import pl.seafta.service.CalculatorService;

@Controller
@AllArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("calculator")
    public String calculatorPage(Model model) {
        model.addAttribute("accountDetails", new AccountDetails());
        return "calculator";
    }

    @PostMapping("calculator")
    public String calculator(@ModelAttribute("accountDetails") AccountDetails accountDetails) {
        return calculatorService.calculate(accountDetails);
    }

}
