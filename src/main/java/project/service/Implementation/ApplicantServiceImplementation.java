package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Applicant;
import project.persistence.repositories.ApplicantRepository;
import project.persistence.repositories.UserRepository;
import project.service.ApplicantService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantServiceImplementation implements ApplicantService {

    // Instance Variables
    ApplicantRepository repository;

    // Dependency Injection
    @Autowired
    public ApplicantServiceImplementation(ApplicantRepository repository, UserRepository userRepository) {
        this.repository = repository;
    }

    @Override
    public Applicant save(Applicant applicant){
        return repository.save(applicant);
    }

    @Override
    public void delete(Applicant applicant) {
        repository.delete(applicant);
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
    public ArrayList<Applicant> findAllApplicants (Long ad){
        return repository.findAllApplicants(ad);
    }

    @Override
    public ArrayList<Applicant> findAllApplications (Long users) { return repository.findAllApplications(users); }

    @Override
    public Applicant findByAdAndUser(Long ad, Long users){
        return repository.findByAdAndUser(ad, users);
    }

}
