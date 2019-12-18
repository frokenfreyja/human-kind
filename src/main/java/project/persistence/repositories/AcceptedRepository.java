package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Accepted;

import java.util.ArrayList;
import java.util.List;

public interface AcceptedRepository extends JpaRepository<Accepted, Long> {

    Accepted save(Accepted accepted);

    void delete(Accepted accepted);

    List<Accepted> findAll();

    @Query(value = "SELECT a FROM Accepted a WHERE a.id = ?1")
    Accepted findOne(Long id);

    @Query(value = "SELECT a FROM Accepted a WHERE a.work = ?1")
    ArrayList<Accepted> findAllAccepted(Long work);

    @Query(value = "SELECT a FROM Accepted a WHERE a.users =?1")
    ArrayList<Accepted> findAllApplications(Long user);

    @Query(value = "SELECT a FROM Accepted a WHERE a.work = ?1 and a.users = ?2")
    Accepted findByWorkAndUser(Long work, Long users);
}
