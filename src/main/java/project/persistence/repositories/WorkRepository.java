package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Work;
import java.util.Date;


import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {

    Work save(Work work);

    void delete(Work work);

    List<Work> findAll();

    @Query(value = "SELECT w FROM Work w WHERE w.id = ?1")
    Work findOne(Long id);

    @Query(value = "SELECT w FROM Work w WHERE w.date >= ?1")
    List<Work> findAllActive(Date date);

    @Query(value = "SELECT w FROM Work w WHERE w.closed = f")
    List<Work> findAllOpen();

    List<Work> findByName(String name);

    List<Work> findByDescription(String description);

    List<Work> findByLocation(String location);

    List<Work> findByGenLoc(String genLoc);

    List<Work> findByZipcode(Integer zipcode);

    List<Work> findByZipcodeAndInterest(Integer zipcode, String interest);

    List<Work> findByOrganizationAndInterest(String organization, String interest);

    List<Work> findByOrganizationAndGenLoc(String organization, String genLoc);

    List<Work> findByInterestAndGenLoc(String interest, String genLoc);

    List<Work> findByOrganizationAndInterestAndGenLoc(String organization, String interest, String genLoc);

    List<Work> findByDate(Date date);

    List<Work> findByOwner(Long owner);

    List<Work> findByOrganization(String organization);

    List<Work> findByInterest(String interest);

    List<Work> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description);
}
