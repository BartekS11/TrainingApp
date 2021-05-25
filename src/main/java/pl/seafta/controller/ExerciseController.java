package pl.seafta.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.seafta.persistance.exercise.Exercise;
import pl.seafta.service.ExerciseService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping("exercise")
    public String exercisePage(Model model) {
        List<Exercise> exercises = exerciseService.getAllExercises();
        model.addAttribute("exercises", exercises);
        return "exercise";
    }

    @PostMapping("exercise")
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    @GetMapping("getAllExercises")
    public java.util.List<Exercise> getAll() {
        return exerciseService.getAllExercises();
    }
}
