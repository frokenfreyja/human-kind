package project.service;

import project.persistence.entities.Ad;

import java.util.List;
import java.util.Date;


public interface AdService {

    /**
     * Save a {@link Ad}
     * @param ad {@link Ad} to be saved
     * @return {@link Ad} that was saved
     */
    Ad save(Ad ad);

    /**
     * Delete {@link Ad}
     * @param ad {@link Ad} to be deleted
     */
    void delete(Ad ad);

    /**
     * Get all {@link Ad}s
     * @return A list of {@link Ad}s
     */
    List<Ad> findAll();

    /**
     * Get all {@link Ad}s in a reverse order
     * @return A reversed list of {@link Ad}s
     */
    List<Ad> findAllReverseOrder();

    /**
     * Get all {@link Ad}s that are active in reverse order
     * @param date {@link Date}
     * @return A reversed list of {@link Ad}s
     */
    List<Ad> findAllActive(Date date);

    /**
     * Get all {@link Ad}s that are active
     * @return A list of still active {@link Ad}s
     */
    List<Ad> findAllOpen();

    /**
     * Find a {@link Ad} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Ad} with {@link Long id}
     */
    Ad findOne(Long id);

    /**
     * Find all {@link Ad}s with {@link String name}
     * @param name {@link String}
     * @return All {@link Ad}s with the {@link String name} passed
     */
    List<Ad> findByName(String name);

    /**
     * Find all {@link Ad}s with {@link String description}
     * @param description {@link String}
     * @return All {@link Ad}s with the {@link String description} passed
     */
    List<Ad> findByDescription(String description);

    /**
     * Find all {@link Ad}s with {@link String location}
     * @param location {@link String}
     * @return All {@link Ad}s with the {@link String location} passed
     */
    List<Ad> findByLocation(String location);

    /**
     * Find all {@link Ad}s with {@link Date date}
     * @param date {@link Date}
     * @return All {@link Ad}s with the {@link Date date} passed
     */
    List<Ad> findByDate(Date date);

    /**
     * Find all {@link Ad}s with {@link Long owner}
     * @param owner {@link Long}
     * @return All {@link Ad}s with the {@link Long owner} passed
     */
    List<Ad> findByOwner(Long owner);

    List<Ad> findByOrganization(String organization);

    /**
     * Find all {@link Ad}s with {@link String interest}
     * @param interest {@link String}
     * @return All {@link Ad}s with the {@link String interest} passed
     */
    List<Ad> findByInterest(String interest);

    /**
     * Find all {@link Ad}s with {@link String title, @link String description}
     * @param title {@link String}
     * @param description {@link String}
     * @return All {@link Ad}s with the {@link String title, @link description} passed
     */
    List<Ad> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description);


    List<Ad> findByZipcodeAndInterest(Integer zipcode, String interest);

    List<Ad> findByZipcodeAndInterestReverseOrder(Integer zipcode, String interest);

    List<Ad> findByOrganizationAndInterest(String organization, String interest);

    List<Ad> findByOrganizationAndGenLoc(String organization, String genLoc);

    List<Ad> findByInterestAndGenLoc(String interest, String genLoc);

    List<Ad> findByOrganizationAndInterestAndGenLoc(String organization, String interest, String genLoc);

    List<Ad> findByZipcodeReverseOrder(Integer zipcode);

    List<Ad> findByInterestReverseOrder(String interest);

    List<Ad> findByGenLoc(String genLoc);

}
