package pl.seafta.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.seafta.persistance.exercise.Exercise;
import pl.seafta.persistance.exercise.repository.ExerciseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;



    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }
}
