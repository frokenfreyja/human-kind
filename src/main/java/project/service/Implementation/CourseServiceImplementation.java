package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Course;
import project.persistence.repositories.CourseRepository;
import project.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService {

    // Instance Variables
    CourseRepository repository;

    // Dependency Injection
    @Autowired
    public CourseServiceImplementation(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course save(Course course) { return this.repository.save(course); }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Course findByName(String name) { return repository.findByName(name); }
}
