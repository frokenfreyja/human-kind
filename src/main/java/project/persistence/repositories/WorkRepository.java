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

    List<Work> findByName(String name);

    List<Work> findByDescription(String description);

    List<Work> findByLocation(String location);

    List<Work> findByDate(Date date);

    List<Work> findByDuration(int duration);

    List<Work> findByOwner(Long owner);

    List<Work> findByInterest(String interest);

    List<Work> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description);
}
