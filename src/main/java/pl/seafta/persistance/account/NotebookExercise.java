package pl.seafta.persistance.account;

import lombok.*;
import pl.seafta.persistance.exercise.Exercise;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "notebookexercise")
public class NotebookExercise {

    @Id
    @GeneratedValue()
    @Column(name = "id_notebook")
    private Long Id;
    private String description;
    private String name;
}
