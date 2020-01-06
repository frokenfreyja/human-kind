package project.service.Implementation;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.service.EmailService;

@Service
public class EmailServiceImplementation implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendAcceptMail(User user, String message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());
        msg.setSubject("You've been accepted");
        if(message == null)
            msg.setText("Congratulations " + user.getName() + ", you've been accepted to take part in applied volunteer work.");
        else
            msg.setText(message);
        javaMailSender.send(msg);
    }

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }
}
