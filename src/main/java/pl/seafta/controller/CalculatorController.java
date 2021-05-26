package pl.seafta.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.seafta.persistance.account.Account;
import pl.seafta.persistance.account.AccountDetails;
import pl.seafta.persistance.account.repository.AccountDetailsRepository;
import pl.seafta.service.CalculatorService;

@Controller
@AllArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final AccountDetailsRepository accountDetailsRepository;

    @GetMapping("calculatortest")
    public String calculatorPage(Model model) {
        model.addAttribute("accountDetails", new AccountDetails());
        return "calculatortest";
    }

    @PostMapping("calculatortest")
    public String calculator(@ModelAttribute("accountDetails") AccountDetails accountDetails) {
        calculatorService.calculate(accountDetails);
        return "redirect:results";
    }

    @GetMapping("results")
    public String getResults(Model model) {
        AccountDetails accountDetails = accountDetailsRepository.getOne((long)1);
        model.addAttribute("accountDetails", accountDetails);
        return "results";
    }

}
