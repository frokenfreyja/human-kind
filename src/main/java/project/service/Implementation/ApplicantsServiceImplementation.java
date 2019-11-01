package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Applicants;
import project.persistence.entities.User;
import project.persistence.repositories.ApplicantsRepository;
import project.service.ApplicantsService;

import javax.swing.*;
import java.util.List;

@Service
public class ApplicantsServiceImplementation implements ApplicantsService {

    ApplicantsRepository repository;

    @Autowired
    public ApplicantsServiceImplementation(ApplicantsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Applicants> findAll() { return repository.findAll(); }

   /* @Override
    public List<User> findApplicants(Long workID) {
        return repository.findApplicants(workID);
    }*/
}
