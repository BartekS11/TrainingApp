package pl.seafta.persistance.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountDetails {

    @Id
    private Long Id;
    private String sex;
    private double height;
    private double weight;
    private double age;
    private double activity;
    private double cpm;
    private double bmi;
    private double bmr;
}
