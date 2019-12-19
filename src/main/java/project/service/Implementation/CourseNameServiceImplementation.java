package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.CourseName;
import project.persistence.repositories.CourseNameRepository;
import project.service.CourseNameService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseNameServiceImplementation implements CourseNameService {

    CourseNameRepository repository;

    @Autowired
    public CourseNameServiceImplementation(CourseNameRepository repository){
        this.repository = repository;
    }

    @Override
    public CourseName save(CourseName courseName){
        return repository.save(courseName);
    }

    @Override
    public void delete(CourseName courseName) {
        repository.delete(courseName);
    }

    @Override
    public List<CourseName> findAll() {
        return repository.findAll();
    }

    @Override
    public CourseName findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public ArrayList<CourseName> findAllCourses(Long course){
        return repository.findAllCourses(course);
    }

    @Override
    public ArrayList<CourseName> findAllUsers (Long users) { return repository.findAllUsers(users); }

    @Override
    public CourseName findByCourseAndUser(Long course, Long users){
        return repository.findByCourseAndUser(course, users);
    }

}
