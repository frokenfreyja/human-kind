package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.ConfirmationToken;


public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {

    void delete(ConfirmationToken confirmationToken);

    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
