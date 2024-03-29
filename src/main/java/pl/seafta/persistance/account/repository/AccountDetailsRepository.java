package pl.seafta.persistance.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.seafta.persistance.account.AccountDetails;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
}
