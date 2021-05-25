package pl.seafta.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.seafta.persistance.account.AccountDetails;
import pl.seafta.persistance.account.AccountDetailsRequest;
import pl.seafta.persistance.account.repository.AccountDetailsRepository;

import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class CalculatorService {

    private final AccountDetailsRepository accountDetailsRepository;
    public String calculate(@NotNull AccountDetails accountDetails) {
        double bmr;
        double cpm;
        double bmi;

        if(accountDetails.getSex().equals("FEMALE"))
            bmr = 9.99 * accountDetails.getWeight() + 6.25 * accountDetails.getHeight() - 4.92 * accountDetails.getAge() - 161;
        else
            bmr = 9.99 * accountDetails.getWeight() + 6.25 * accountDetails.getHeight() - 4.92 * accountDetails.getAge() + 5;

        accountDetails.setBmr(bmr);

        cpm = bmr * accountDetails.getActivity();
        accountDetails.setCpm(cpm);

        bmi = accountDetails.getWeight() / Math.sqrt(accountDetails.getHeight() / 100);
        accountDetails.setBmi(bmi);

        accountDetailsRepository.save(accountDetails);

        return "works";
    }
}
