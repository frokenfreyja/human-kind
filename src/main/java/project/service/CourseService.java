package project.service;

import project.persistence.entities.Course;

import java.util.List;

public interface CourseService {

    /**
     * save a {@link Course}
     * @param course {@link Course} to be saved
     * @return {@link Course} that was saved
     */
    Course save(Course course);

    /**
     * Get all {@link Course}s
     * @return A list of {@link Course}s
     */
    List<Course> findAll();

    /**
     * Find a {@link Course} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Course} with {@link Long id}
     */
    Course findOne(Long id);

    /**
     * Find a {@link Course} based on {@link String name}
     * @param name {@link String}
     * @return A {@link Course} with {@link String name}
     */
    Course findByName(String name);
}
