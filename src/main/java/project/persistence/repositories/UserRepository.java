package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    void delete(User user);

    @Query(value = "SELECT u FROM User u WHERE u.id = ?1")
    User findOne(Long id);

    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
}
