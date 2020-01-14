package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.ConfirmationToken;
import project.persistence.repositories.ConfirmationTokenRepository;
import project.service.ConfirmationTokenService;

@Service
public class ConfirmationTokenServiceImplementation implements ConfirmationTokenService {
    // Instance Variables
    ConfirmationTokenRepository repository;

    // Dependency Injection
    @Autowired
    public ConfirmationTokenServiceImplementation(ConfirmationTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConfirmationToken save(ConfirmationToken confirmationToken) {
        return repository.save(confirmationToken);
    }

    @Override
    public void delete(ConfirmationToken confirmationToken) { repository.delete(confirmationToken); }

    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        return repository.findByConfirmationToken(confirmationToken);
    }
}
