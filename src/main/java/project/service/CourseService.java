package project.service;

import project.persistence.entities.Course;

import java.util.List;

public interface CourseService {

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
}
