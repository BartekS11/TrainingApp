package pl.seafta.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.seafta.persistance.account.NotebookExercise;
import pl.seafta.persistance.account.repository.NotebookExerciseRepository;
import pl.seafta.persistance.exercise.Exercise;

import java.util.List;

@Service
@AllArgsConstructor
public class NotebookExerciseService {
    private final NotebookExerciseRepository notebookExerciseRepository;

    public NotebookExercise create(NotebookExercise notebookExercise) {
        return notebookExerciseRepository.save(notebookExercise);
    }

    public List<NotebookExercise> getAllExercises() {
        return notebookExerciseRepository.findAll();
    }
}
