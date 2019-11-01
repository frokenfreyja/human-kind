package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Applicants;
import project.persistence.entities.User;

import java.util.List;

public interface ApplicantsRepository extends JpaRepository<Applicants, Long> {

    List<Applicants> findAll();

   /*@Query(value = "SELECT u.id, u.name, u.image_name, u.bio FROM User u INNER JOIN Applicants a ON u.id = a.userid WHERE a.work_id = ?1")
   List<User> findApplicants(Long workID);
*/
}

