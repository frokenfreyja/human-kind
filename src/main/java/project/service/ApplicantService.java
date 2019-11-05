package project.service;

import project.persistence.entities.Applicant;

import java.util.List;

public interface ApplicantService {

    /**
     * Get all {@link Applicant}s
     * @return A list of {@link Applicant}s
     */
    List<Applicant> findAll();

    /**
     * Find a {@link Applicant} based on {@link Long id}
     * @param id {@link Long}
     * @return A {@link Applicant} with {@link Long id}
     */
    Applicant findOne(Long id);
}
