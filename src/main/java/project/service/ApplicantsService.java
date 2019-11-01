package project.service;

import project.persistence.entities.Applicants;
import project.persistence.entities.User;

import java.util.List;

public interface ApplicantsService {

    /**
     * Get all {@link Applicants}s
     * @return A list of {@link Applicants}s
     */
    List<Applicants> findAll();

 /*   /**
     * Get all {@link User}s
     * @return A list of {@link User}s
     */
   // List<User> findApplicants(Long workID);

}
