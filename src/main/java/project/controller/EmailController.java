package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.service.EmailService;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;

@Controller
public class EmailController {
    private EmailService emailService;

    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @RequestMapping(value = "/testemail", method = RequestMethod.GET)
    public String testemail(Model model, HttpSession httpSession){
        emailService.sendAcceptMail("ruslatunna1907@gmail.com");


        return "redirect:/";
    }

}
