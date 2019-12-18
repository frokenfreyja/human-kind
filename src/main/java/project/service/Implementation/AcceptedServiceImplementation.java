package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Accepted;
import project.persistence.repositories.AcceptedRepository;
import project.persistence.repositories.UserRepository;
import project.service.AcceptedService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcceptedServiceImplementation implements AcceptedService {
    // Instance Variables
    AcceptedRepository repository;
    UserRepository userRepository;

    // Dependency Injection
    @Autowired
    public AcceptedServiceImplementation(AcceptedRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Accepted save(Accepted applicant){
        return repository.save(applicant);
    }

    @Override
    public void delete(Accepted applicant) {
        repository.delete(applicant);
    }

    @Override
    public List<Accepted> findAll() {
        return repository.findAll();
    }

    @Override
    public Accepted findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public ArrayList<Accepted> findAllAccepted (Long work){
        return repository.findAllAccepted(work);
    }

    @Override
    public ArrayList<Accepted> findAllApplications (Long users) { return repository.findAllApplications(users); }

    @Override
    public Accepted findByWorkAndUser(Long work, Long users){
        return repository.findByWorkAndUser(work, users);
    }

}
