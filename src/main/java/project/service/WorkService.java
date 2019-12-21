package project.service;

import project.persistence.entities.Work;

import java.util.List;
import java.util.Date;


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
     * Get all {@link Work}s that are active in reverse order
     * @param date {@link Date}
     * @return A reversed list of {@link Work}s
     */
    List<Work> findAllActive(Date date);

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
     * Find all {@link Work}s with {@link String description}
     * @param description {@link String}
     * @return All {@link Work}s with the {@link String description} passed
     */
    List<Work> findByDescription(String description);

    /**
     * Find all {@link Work}s with {@link String location}
     * @param location {@link String}
     * @return All {@link Work}s with the {@link String location} passed
     */
    List<Work> findByLocation(String location);

    /**
     * Find all {@link Work}s with {@link Date date}
     * @param date {@link Date}
     * @return All {@link Work}s with the {@link Date date} passed
     */
    List<Work> findByDate(Date date);

    /**
     * Find all {@link Work}s with {@link int duration}
     * @param duration {@link int}
     * @return All {@link Work}s with the {@link int duration} passed
     */
    List<Work> findByDuration(int duration);

    /**
     * Find all {@link Work}s with {@link Long owner}
     * @param owner {@link Long}
     * @return All {@link Work}s with the {@link Long owner} passed
     */
    List<Work> findByOwner(Long owner);

    List<Work> findByOrganization(String organization);

    /**
     * Find all {@link Work}s with {@link String interest}
     * @param interest {@link String}
     * @return All {@link Work}s with the {@link String interest} passed
     */
    List<Work> findByInterest(String interest);

    /**
     * Find all {@link Work}s with {@link String title, @link String description}
     * @param title {@link String}
     * @param description {@link String}
     * @return All {@link Work}s with the {@link String title, @link description} passed
     */
    List<Work> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description);


    List<Work> findByZipcodeAndInterest(Integer zipcode, String interest);

    List<Work> findByZipcodeAndInterestReverseOrder(Integer zipcode, String interest);

    List<Work> findByOrOrganizationAndInterest(String organization, String interest);

    List<Work> findByZipcodeReverseOrder(Integer zipcode);

    List<Work> findByInterestReverseOrder(String interest);
}
