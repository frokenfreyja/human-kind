package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

    // Instance Variables
    UserRepository repository;
     @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Dependency Injection
    @Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public User findByEmail(String email){ return repository.findByEmail(email);}
}
