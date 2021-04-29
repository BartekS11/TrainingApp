package pl.seafta.persistance.ConfirmationToken;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.seafta.persistance.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @Column
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "account_id"
    )
    private Account account;


    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, Account account) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.account = account;
    }
}
