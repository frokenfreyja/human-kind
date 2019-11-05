package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Applicant;
import project.persistence.repositories.ApplicantRepository;
import project.service.ApplicantService;

import java.util.List;

@Service
public class ApplicantServiceImplementation implements ApplicantService {

    // Instance Variables
    ApplicantRepository repository;

    // Dependency Injection
    @Autowired
    public ApplicantServiceImplementation(ApplicantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Applicant> findAll() {
        return repository.findAll();
    }

    @Override
    public Applicant findOne(Long id) {
        return repository.findOne(id);
    }
}
