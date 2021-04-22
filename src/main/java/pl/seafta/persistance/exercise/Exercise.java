package pl.seafta.persistance.exercise;

import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ExerciseLevel exerciseLevel;
}
