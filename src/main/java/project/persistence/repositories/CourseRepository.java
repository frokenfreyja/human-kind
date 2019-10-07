package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAll();

    @Query(value = "SELECT c FROM course c WHERE course.id = ?1")
    Course findOne(Long id);
}
