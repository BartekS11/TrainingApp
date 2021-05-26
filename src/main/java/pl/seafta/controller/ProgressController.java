package pl.seafta.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.seafta.persistance.exercise.Exercise;
import pl.seafta.service.ExerciseService;

@Controller
@RequestMapping
@AllArgsConstructor
public class ProgressController {

    private final ExerciseService exerciseService;

    @GetMapping("progress")
    public String accountPage(Model model) {
        return "progress";
    }

    @PostMapping("progress")
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }
}
