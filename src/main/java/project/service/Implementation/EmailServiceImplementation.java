package project.service.Implementation;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import project.service.EmailService;

@Service
public class EmailServiceImplementation implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendAcceptMail(String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("You've been accepted");
        msg.setText("Congratulations you've been accepted to take part in applied volunteer work");

        javaMailSender.send(msg);
    }

}
