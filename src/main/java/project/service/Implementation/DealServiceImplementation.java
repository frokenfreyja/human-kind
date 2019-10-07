package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Deal;
import project.persistence.repositories.DealRepository;
import project.service.DealService;

import java.util.List;

@Service
public class DealServiceImplementation implements DealService {

    // Instance Variables
    DealRepository repository;

    // Dependency Injection
    @Autowired
    public DealServiceImplementation(DealRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Deal> findAll() {
        return repository.findAll();
    }

    @Override
    public Deal findOne(Long id) {
        return repository.findOne(id);
    }
}
