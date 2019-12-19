package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.CourseName;

import java.util.ArrayList;
import java.util.List;

public interface CourseNameRepository extends JpaRepository<CourseName, Long> {

    CourseName save(CourseName courseName);

    void delete(CourseName courseName);

    List<CourseName> findAll();

    @Query(value = "SELECT c FROM CourseName c WHERE c.id = ?1")
    CourseName findOne(Long id);

    @Query(value = "SELECT c FROM CourseName c WHERE c.course = ?1")
    ArrayList<CourseName> findAllCourses(Long course);

    @Query(value = "SELECT c FROM CourseName c WHERE c.users =?1")
    ArrayList<CourseName> findAllUsers(Long users);

    @Query(value = "SELECT c FROM CourseName c WHERE c.course = ?1 and c.users = ?2")
    CourseName findByCourseAndUser(Long course, Long users);
}
