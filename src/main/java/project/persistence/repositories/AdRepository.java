package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Ad;
import java.util.Date;
import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad save(Ad ad);

    void delete(Ad ad);

    List<Ad> findAll();

    @Query(value = "SELECT w FROM Ad w WHERE w.id = ?1")
    Ad findOne(Long id);

    @Query(value = "SELECT w FROM Ad w WHERE w.date >= ?1")
    List<Ad> findAllActive(Date date);

    @Query(value = "SELECT w FROM Ad w WHERE w.closed = f")
    List<Ad> findAllOpen();

    List<Ad> findByName(String name);

    List<Ad> findByGenLoc(String genLoc);

    List<Ad> findByOrganizationAndInterest(String organization, String interest);

    List<Ad> findByOrganizationAndGenLoc(String organization, String genLoc);

    List<Ad> findByInterestAndGenLoc(String interest, String genLoc);

    List<Ad> findByOrganizationAndInterestAndGenLoc(String organization, String interest, String genLoc);

    List<Ad> findByOwner(Long owner);

    List<Ad> findByOrganization(String organization);

    List<Ad> findByInterest(String interest);

    List<Ad> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description);
}
