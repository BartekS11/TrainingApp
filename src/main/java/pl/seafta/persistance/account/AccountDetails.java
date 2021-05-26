package pl.seafta.persistance.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_details")
public class AccountDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String sex;
    private double height;
    private double weight;
    private double age;
    private double activity;
    private double cpm;
    private double bmi;
    private double bmr;
}
