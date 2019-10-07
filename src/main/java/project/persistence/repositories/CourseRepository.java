package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAll();

    @Query(value = "SELECT c FROM Course c WHERE c.id = ?1")
    Course findOne(Long id);
}
