package project.service;

import org.springframework.mail.SimpleMailMessage;
import project.persistence.entities.User;

public interface EmailService {
    /**
     * Sends and acceptance email to {@link User} with {String message}
     * @param user
     */
    void sendAcceptMail(User user, String message);

    void sendEmail(SimpleMailMessage email);
}
