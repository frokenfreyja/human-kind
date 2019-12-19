package project.service;

import project.persistence.entities.CourseName;

import java.util.ArrayList;
import java.util.List;

public interface CourseNameService {
    /**
     * save a {@link CourseName}
     * @param courseName {@link CourseName} to be saved
     * @return {@link CourseName} that was saved
     */
    CourseName save(CourseName courseName);

    /**
     * delete a {@link CourseName}
     * @param courseName{@link CourseName} to be deleted
     * @return {@link CourseName} that was deleted
     */
    void delete(CourseName courseName);

    /**
     * Get all {@link CourseName}s
     * @return A list of {@link CourseName}s
     */
    List<CourseName> findAll();

    /**
     * Find a {@link CourseName} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link CourseName} with {@link Long id}
     */
    CourseName findOne(Long id);

    /**
     * Get list of {@link CourseName}s
     * @param course {@link Long}
     * @return list of {@link CourseName}s with {@link Long course}
     */
    ArrayList<CourseName> findAllCourses(Long course);

    /**
     * Get list of {@link CourseName}s
     * @param users {@link Long}
     * @return list of {@link CourseName}s with {@link Long users}
     */
    ArrayList<CourseName> findAllUsers(Long users);

    /**
     * Get list of {@link CourseName}s
     * @param course {@link Long}
     * @param users {@link Long}
     * @return list of {@link CourseName}s with {@link Long course} and {@link Long users}
     */
    CourseName findByCourseAndUser(Long course, Long users);

}
