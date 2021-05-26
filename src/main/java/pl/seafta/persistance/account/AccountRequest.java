package pl.seafta.persistance.account;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class AccountRequest {
    private  String firstName;
    private  String lastName;
    private  String email;
    @NotNull
    private  String password;
}
