package pl.seafta.service;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.seafta.persistance.ConfirmationToken.ConfirmationToken;
import pl.seafta.persistance.account.Account;
import pl.seafta.persistance.account.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {

    private final static String ACCOUNT_NOT_FOUND = "Account with email %s not found";
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(ACCOUNT_NOT_FOUND, email)));
    }

    public String signUpAccount(Account account) {
        boolean userExists = accountRepository
                .findByEmail(account.getEmail())
                .isPresent();
        if(userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = passwordEncoder
                .encode(account.getPassword());

        account.setPassword(encodedPassword);
        accountRepository.save(account);


        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
              token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                account
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;

        //TODO: SEND EMAIL
    }

    public int enableAccount(String email) {
        return accountRepository.enableAccount(email);
    }
}
