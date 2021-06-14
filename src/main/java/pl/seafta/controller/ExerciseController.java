package pl.seafta.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.seafta.persistance.account.NotebookExercise;
import pl.seafta.persistance.account.repository.NotebookExerciseRepository;
import pl.seafta.persistance.exercise.Exercise;
import pl.seafta.persistance.exercise.repository.ExerciseRepository;
import pl.seafta.service.ExerciseService;
import pl.seafta.service.NotebookExerciseService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ExerciseRepository exerciseRepository;
    private final NotebookExerciseService notebookExerciseService;

    @GetMapping("exercise")
    public String exercisePage(Model model) {
        Exercise exercise = new Exercise();
        model.addAttribute("exercise", exercise);
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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("exercise") Exercise exercise) {
        NotebookExercise notebookExercise = NotebookExercise.builder()
                .description("")
                .name(exercise.getName())
                .build();
        notebookExerciseService.create(notebookExercise);
        return "redirect:/progress";
    }
}
