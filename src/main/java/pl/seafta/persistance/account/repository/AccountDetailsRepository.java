package pl.seafta.persistance.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.seafta.persistance.account.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
}
