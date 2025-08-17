package anth.tech.springforum;

import anth.tech.springforum.model.ForumUser;
import anth.tech.springforum.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private ForumUser testUser;

    @Test
    void savedUserCanBeFoundById() {
        ForumUser savedUser = userRepository.findById(testUser.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals(testUser.getId(), savedUser.getId());
        assertEquals(testUser.getUsername(), savedUser.getUsername());
        assertEquals(testUser.getEmail(), savedUser.getEmail());
        assertEquals(testUser.getPasswordHash(), savedUser.getPasswordHash());
        assertEquals(testUser.getCreatedOn(), savedUser.getCreatedOn());
        assertEquals(testUser.getFirstname(), savedUser.getFirstname());
        assertEquals(testUser.getLastname(), savedUser.getLastname());
    }

    @Test
    void savedUserCanBeDeletedById() {
        userRepository.deleteById(testUser.getId());
        ForumUser deletedUser = userRepository.findById(testUser.getId()).orElse(null);
        assertNull(deletedUser);
    }

    @Test
    void savedUserCanBeFoundByUsername() {
        ForumUser savedUser = userRepository.findByUsername(testUser.getUsername());
        assertNotNull(savedUser);
        assertEquals(testUser.getUsername(), savedUser.getUsername());
    }

    @BeforeEach
    public void setUp() {
        testUser = new ForumUser("testusername", "test@email.com", "testpassword", "testfirstname", "testlastname");
        userRepository.save(testUser);
    }
    @AfterEach
    public void tearDown() {
        userRepository.delete(testUser);
    }
}
