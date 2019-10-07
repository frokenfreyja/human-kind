package project.service;

import project.persistence.entities.Work;

import java.util.List;

public interface WorkService {

    /**
     * Save a {@link Work}
     * @param work {@link Work} to be saved
     * @return {@link Work} that was saved
     */
    Work save(Work work);

    /**
     * Delete {@link Work}
     * @param work {@link Work} to be deleted
     */
    void delete(Work work);

    /**
     * Get all {@link Work}s
     * @return A list of {@link Work}s
     */
    List<Work> findAll();

    /**
     * Get all {@link Work}s in a reverse order
     * @return A reversed list of {@link Work}s
     */
    List<Work> findAllReverseOrder();

    /**
     * Find a {@link Work} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Work} with {@link Long id}
     */
    Work findOne(Long id);

    /**
     * Find all {@link Work}s with {@link String name}
     * @param name {@link String}
     * @return All {@link Work}s with the {@link String name} passed
     */
    List<Work> findByName(String name);

    /**
     * Find all {@link Work}s with {@link String location}
     * @param location {@link String}
     * @return All {@link Work}s with the {@link String location} passed
     */
    List<Work> findByLocation(String location);

    /**
     * Find all {@link Work}s with {@link String date}
     * @param date {@link String}
     * @return All {@link Work}s with the {@link String date} passed
     */
    List<Work> findByDate(String date);

    /**
     * Find all {@link Work}s with {@link int duration}
     * @param duration {@link int}
     * @return All {@link Work}s with the {@link int duration} passed
     */
    List<Work> findByDuration(int duration);

    /**
     * Find all {@link Work}s with {@link String owner}
     * @param owner {@link String}
     * @return All {@link Work}s with the {@link String owner} passed
     */
    List<Work> findByOwner(String owner);

    /**
     * Find all {@link Work}s with {@link String interest}
     * @param interest {@link String}
     * @return All {@link Work}s with the {@link String interest} passed
     */
    List<Work> findByInterest(String interest);
}
