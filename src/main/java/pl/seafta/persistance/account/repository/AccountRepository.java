package pl.seafta.persistance.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.seafta.persistance.account.Account;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
