package anth.tech.springforum.repository;

import anth.tech.springforum.model.ForumUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface UserRepository extends CrudRepository<ForumUser, Long> {
    ForumUser findByUsername(String username);
}
