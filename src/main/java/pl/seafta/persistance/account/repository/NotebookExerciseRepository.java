package pl.seafta.persistance.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.seafta.persistance.account.AccountDetails;
import pl.seafta.persistance.account.NotebookExercise;

@Repository
public interface NotebookExerciseRepository extends JpaRepository<NotebookExercise, Long> {
}
