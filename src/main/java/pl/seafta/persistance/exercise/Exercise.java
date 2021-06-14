package pl.seafta.persistance.exercise;

import lombok.*;
import pl.seafta.persistance.account.AccountDetails;
import pl.seafta.persistance.account.NotebookExercise;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ExerciseLevel exerciseLevel;
}
