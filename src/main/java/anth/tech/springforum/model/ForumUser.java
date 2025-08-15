package anth.tech.springforum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;

@Entity
@Data
public class ForumUser {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique=true)
    @Size(min=5, message="Username must be at least 5 characters long")
    private String username;

    @NotNull
    @Column(unique=true)
    private String email;

    @NotNull
    private String passwordHash;

    @CreationTimestamp(source=SourceType.DB)
    private Instant createdOn;

    private String firstname;
    private String lastname;
}
