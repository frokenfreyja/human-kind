package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Ad;
import project.persistence.repositories.AdRepository;
import project.service.AdService;

import java.util.Collections;
import java.util.List;
import java.util.Date;


@Service
public class AdServiceImplementation implements AdService {

    // Instance Variables
    AdRepository repository;

    // Dependency Injection
    @Autowired
    public AdServiceImplementation(AdRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ad save(Ad ad) {
        return repository.save(ad);
    }

    @Override
    public void delete(Ad ad) {
        repository.delete(ad);
    }

    @Override
    public List<Ad> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Ad> findAllReverseOrder() {
        List<Ad> ad = repository.findAll();
        // Reverse the list
        Collections.reverse(ad);

        return ad;
    }

    @Override
    public List<Ad> findAllActive(Date date) {
        List<Ad> ad = repository.findAllActive(date);
        Collections.reverse(ad);
        return ad;
    }

    @Override
    public List<Ad> findAllOpen(){return  repository.findAllOpen();}

    @Override
    public Ad findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Ad> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Ad> findByOwner(Long owner) {
        return repository.findByOwner(owner);
    }

    @Override
    public List<Ad> findByOrganization(String organization) {
        return repository.findByOrganization(organization);
    }

    @Override
    public List<Ad> findByInterest(String interest) {
        return repository.findByInterest(interest);
    }

    @Override
    public List<Ad> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description) {
        return repository.findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(title, description);
    }

    @Override
    public List<Ad> findByOrganizationAndInterest(String organization, String interest) {
        return repository.findByOrganizationAndInterest(organization, interest);
    }

    @Override
    public List<Ad> findByOrganizationAndGenLoc(String organization, String genLoc) {
        return repository.findByOrganizationAndGenLoc(organization, genLoc);
    }

    @Override
    public List<Ad> findByInterestAndGenLoc(String interest, String genLoc) {
        return repository.findByInterestAndGenLoc(interest, genLoc);
    }

    @Override
    public List<Ad> findByOrganizationAndInterestAndGenLoc(String organization, String interest, String genLoc) {
        return repository.findByOrganizationAndInterestAndGenLoc(organization, interest, genLoc);
    }

    @Override
    public List<Ad> findByInterestReverseOrder(String interest) {
        List<Ad> items = repository.findByInterest(interest);
        // Reverse the list
        Collections.reverse(items);
        return items;
    }

    @Override
    public List<Ad> findByGenLoc(String genLoc) {
        return repository.findByGenLoc(genLoc);
    }
}
