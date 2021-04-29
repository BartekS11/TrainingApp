package pl.seafta.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.seafta.persistance.account.AccountRequest;

import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return true;
    }
}
