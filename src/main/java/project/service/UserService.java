package project.service;

import project.persistence.entities.User;
import java.util.List;

public interface UserService {

    /**
     * Save a {@link User}
     * @param user {@link User} to be saved
     * @return {@link User} that was saved
     */
    User save(User user);

    /**
     * Delete {@link User}
     * @param user {@link User} to be deleted
     */
    void delete(User user);

    List<User> findAll();

    List<User> findAllByOrderByNameAsc();

    /**
     * Find a {@link User} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link User} with {@link Long id}
     */
    User findOne(Long id);

    /**
     * Find a {@link User} based in {@link String email}
     * @param email {@link String}
     * @return A {@link User} with {@link String email}
     */
    User findByEmail(String email);

    User findByName(String name);
}
