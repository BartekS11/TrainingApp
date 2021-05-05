package pl.seafta.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.seafta.persistance.account.AccountDetails;
import pl.seafta.service.CalculatorService;

@Controller
@AllArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("Account/calculator")
    public String calculatorPage() {
        return "calculator";
    }

    @PostMapping("Account/calculator")
    public String calculator(@RequestBody AccountDetails accountDetails) {
        return calculatorService.calculate(accountDetails);
    }

}
