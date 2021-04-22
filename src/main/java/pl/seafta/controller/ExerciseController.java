package pl.seafta.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.seafta.persistance.exercise.Exercise;
import pl.seafta.service.ExerciseService;

@RestController
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping("/exercise")
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    @GetMapping("/getAllExercises")
    public java.util.List<Exercise> getAll() {
        return exerciseService.getAllExercises();
    }
}
