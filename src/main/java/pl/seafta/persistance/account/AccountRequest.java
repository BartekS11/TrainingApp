package pl.seafta.persistance.account;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}
