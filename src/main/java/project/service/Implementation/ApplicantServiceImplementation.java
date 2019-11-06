package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Applicant;
import project.persistence.entities.User;
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
    public Applicant save(Applicant applicant){
        return repository.save(applicant);
    }

    @Override
    public List<Applicant> findAll() {
        return repository.findAll();
    }

    @Override
    public Applicant findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Applicant> findAllApplicants (Long work ){
        return repository.findAllApplicants(work);
    }
}
