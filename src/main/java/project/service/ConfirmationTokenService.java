package project.service;

import project.persistence.entities.ConfirmationToken;

public interface ConfirmationTokenService {
    /**
     * save a {@link ConfirmationToken}
     * @param confirmationToken {@link ConfirmationToken} to be saved
     * @return {@link ConfirmationToken} that was saved
     */
    ConfirmationToken save(ConfirmationToken confirmationToken);

    /**
     * delete a {@link ConfirmationToken}
     * @param confirmationToken {@link ConfirmationToken} to be saved
     * @return {@link ConfirmationToken} that was saved
     */
    void delete(ConfirmationToken confirmationToken);

    /**
     * Find a {@link ConfirmationToken} based on {@link String confirmationToken}
     * @param confirmationToken {@link String}
     * @return A {@link ConfirmationToken} with {@link String confirmationToken}
     */
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
