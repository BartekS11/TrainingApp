package pl.seafta.service;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.seafta.persistance.account.Account;
import pl.seafta.persistance.account.AccountRequest;
import pl.seafta.persistance.account.AccountRole;
import pl.seafta.persistance.account.repository.AccountRepository;


@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {

    private final static String ACCOUNT_NOT_FOUND = "Account with email %s not found";
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(ACCOUNT_NOT_FOUND, email)));
    }

    public String register(AccountRequest request) {
        return signUpAccount(
              new Account(
                      request.getFirstName(),
                      request.getLastName(),
                      request.getEmail(),
                      request.getPassword(),
                      AccountRole.USER
              )
        );
    }

    public String signUpAccount(Account account) {
        boolean userExists = accountRepository
                .findByEmail(account.getEmail())
                .isPresent();
        if(userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(account.getPassword());

        account.setPassword(encodedPassword);
        accountRepository.save(account);

        return "";
    }
}
