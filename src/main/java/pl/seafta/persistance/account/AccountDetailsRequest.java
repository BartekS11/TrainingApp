package pl.seafta.persistance.account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountDetailsRequest {
    private final String sex;
    private final double height;
    private final double weight;
    private final double age;
    private final double activity;
}
