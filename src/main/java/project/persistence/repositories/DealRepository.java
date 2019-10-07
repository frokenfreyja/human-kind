package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Deal;

import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Long> {

    List<Deal> findAll();

    @Query(value = "SELECT d FROM Deal d WHERE d.id = ?1")
    Deal findOne(Long id);
}
