package project.service;

import project.persistence.entities.Applicant;

import java.util.ArrayList;
import java.util.List;

public interface ApplicantService {

    /**
     * save a {@link Applicant}
     * @param applicant {@link Applicant} to be saved
     * @return {@link Applicant} that was saved
     */
    Applicant save(Applicant applicant);

    /**
     * delete a {@link Applicant}
     * @param applicant {@link Applicant} to be deleted
     * @return {@link Applicant} that was deleted
     */
    void delete(Applicant applicant);

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
     * @param ad {@link Long}
     * @return list of {@link Applicant}s with {@link Long ad}
     */
    ArrayList<Applicant> findAllApplicants(Long ad);

    /**
     * Get list of {@link Applicant}s
     * @param users {@link Long}
     * @return list of {@link Applicant}s with {@link Long user}
     */
    ArrayList<Applicant> findAllApplications(Long users);

    /**
     * Get list of {@link Applicant}s
     * @param ad {@link Long}
     * @param users {@link Long}
     * @return list of {@link Applicant}s with {@link Long ad} and {@link Long users}
     */
    Applicant findByAdAndUser(Long ad, Long users);

}
