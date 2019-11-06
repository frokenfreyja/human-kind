package project.service;

import project.persistence.entities.Applicant;

import java.util.List;

public interface ApplicantService {

    /**
     * save a {@link Applicant}
     * @param applicant {@link Applicant} to be saved
     * @return {@link Applicant} that was saved
     */
    Applicant save(Applicant applicant);

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

    /**
     * Get list of {@link Applicant}s
     * @param work {@link Long}
     * @return list of {@link Applicant}s with {@link Long work}
     */
    List<Applicant> findAllApplicants(Long work);
}
