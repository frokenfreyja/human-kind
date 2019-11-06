package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Applicant;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    Applicant save(Applicant applicant);

    List<Applicant> findAll();

    @Query(value = "SELECT a FROM Applicant a WHERE a.id = ?1")
    Applicant findOne(Long id);

    @Query(value = "SELECT a FROM Applicant a WHERE a.work = ?1")
    List<Applicant> findAllApplicants(Long work);
}
