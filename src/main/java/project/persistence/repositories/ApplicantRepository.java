package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Applicant;
import project.persistence.entities.User;

import java.util.ArrayList;
import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    Applicant save(Applicant applicant);

    void delete(Applicant applicant);

    List<Applicant> findAll();

    @Query(value = "SELECT a FROM Applicant a WHERE a.id = ?1")
    Applicant findOne(Long id);

    @Query(value = "SELECT a FROM Applicant a WHERE a.work = ?1")
    ArrayList<Applicant> findAllApplicants(Long work);

    @Query(value = "SELECT a FROM Applicant a WHERE a.work = ?1 and a.users = ?2")
    ArrayList<Applicant> findByWorkAndUser(Long work, Long users);



}
