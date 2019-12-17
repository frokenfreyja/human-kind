package project.service;

import project.persistence.entities.Accepted;

import java.util.ArrayList;
import java.util.List;

public interface AcceptedService {
    /**
     * save a {@link Accepted}
     * @param accepted {@link Accepted} to be saved
     * @return {@link Accepted} that was saved
     */
    Accepted save(Accepted accepted);

    /**
     * delete a {@link Accepted}
     * @param accepted {@link Accepted} to be deleted
     * @return {@link Accepted} that was deleted
     */
    void delete(Accepted accepted);

    /**
     * Get all {@link Accepted}s
     * @return A list of {@link Accepted}s
     */
    List<Accepted> findAll();

    /**
     * Find a {@link Accepted} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Accepted} with {@link Long id}
     */
    Accepted findOne(Long id);


    /**
     * Get list of {@link Accepted}s
     * @param work {@link Long}
     * @return list of {@link Accepted}s with {@link Long work}
     */
    ArrayList<Accepted> findAllAccepted(Long work);

    /**
     * Get list of {@link Accepted}s
     * @param users {@link Long}
     * @return list of {@link Accepted}s with {@link Long user}
     */
    ArrayList<Accepted> findAllApplications(Long users);

    /**
     * Get list of {@link Accepted}s
     * @param work {@link Long}
     * @param users {@link Long}
     * @return list of {@link Accepted}s with {@link Long work} and {@link Long users}
     */
    Accepted findByWorkAndUser(Long work, Long users);

}
