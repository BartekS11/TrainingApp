package pl.seafta.persistance.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.seafta.persistance.exercise.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
