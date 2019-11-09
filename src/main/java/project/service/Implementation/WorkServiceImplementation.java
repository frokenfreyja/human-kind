package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Work;
import project.persistence.repositories.WorkRepository;
import project.service.WorkService;

import java.util.Collections;
import java.util.List;
import java.util.Date;


@Service
public class WorkServiceImplementation implements WorkService {

    // Instance Variables
    WorkRepository repository;

    // Dependency Injection
    @Autowired
    public WorkServiceImplementation(WorkRepository repository) {
        this.repository = repository;
    }

    @Override
    public Work save(Work work) {
        return repository.save(work);
    }

    @Override
    public void delete(Work work) {
        repository.delete(work);
    }

    @Override
    public List<Work> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Work> findAllReverseOrder() {
        List<Work> work = repository.findAll();

        // Reverse the list
        Collections.reverse(work);

        return work;
    }

    @Override
    public Work findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Work> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Work> findByLocation(String location) {
        return repository.findByLocation(location);
    }

    @Override
    public List<Work> findByDate(Date date) {
        return repository.findByDate(date);
    }

    @Override
    public List<Work> findByDuration(int duration) {
        return repository.findByDuration(duration);
    }

    @Override
    public List<Work> findByOwner(Long owner) {
        return repository.findByOwner(owner);
    }

    @Override
    public List<Work> findByInterest(String interest) {
        return repository.findByInterest(interest);
    }
}
