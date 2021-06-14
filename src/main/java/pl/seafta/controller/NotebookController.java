package pl.seafta.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.seafta.persistance.account.NotebookExercise;
import pl.seafta.persistance.exercise.Exercise;
import pl.seafta.service.ExerciseService;
import pl.seafta.service.NotebookExerciseService;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class NotebookController {

    private final NotebookExerciseService notebookExerciseService;

    @GetMapping("progress")
    public String accountPage(Model model) {
        List<NotebookExercise> exercises = notebookExerciseService.getAllExercises();
        model.addAttribute("exercises", exercises);
        return "progress";
    }
}
