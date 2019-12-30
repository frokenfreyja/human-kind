package project.service;

public interface EmailService {
    /**
     * Sends and acceptance email to {@link String email}
     * @param email
     */
    void sendAcceptMail(String email);
}
