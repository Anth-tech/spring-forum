package anth.tech.springforum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;


@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED, force=true)
@AllArgsConstructor
@Setter
@Getter
public class ForumUser {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique=true)
    @Size(min=5, message="Username must be at least 5 characters long")
    private String username;

    @NotNull
    @NotBlank(message="Email is required")
    @Column(unique=true)
    private String email;

    @NotNull
    private String passwordHash;

    @CreationTimestamp(source=SourceType.DB)
    private Instant createdOn;

    private String firstname;
    private String lastname;

    public ForumUser(String username, String email, String password, String firstname, String lastname) {
        this.username = username;
        this.email = email;
        this.passwordHash = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
