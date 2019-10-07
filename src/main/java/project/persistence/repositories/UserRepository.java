package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.User;

public interface UserRepository {

    User save(User user);

    void delete(User user);

    @Query(value = "SELECT u FROM users u WHERE p.id = ?1")
    User findOne(Long id);
}
