package anth.tech.springforum;

import anth.tech.springforum.model.ForumUser;
import anth.tech.springforum.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringForumApplication {

    private static Logger LOG = LoggerFactory.getLogger(SpringForumApplication.class);

    public static void main(String[] args) {
        LOG.info("Starting the Application");
        SpringApplication.run(SpringForumApplication.class, args);
        LOG.info("Application closing");
    }

}
