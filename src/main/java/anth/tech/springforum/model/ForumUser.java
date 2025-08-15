package anth.tech.springforum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;

@Entity
public class ForumUser {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique=true)
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

    public ForumUser() {
    }

    public ForumUser(String username, String email, String passwordHash, String firstname, String lastname) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Instant getCreatedOn() {
        return createdOn;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPasswordHash() {
        return passwordHash;
    }

}
