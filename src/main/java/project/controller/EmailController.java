package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/testemail", method = RequestMethod.GET)
    public String testemail(Model model, HttpSession httpSession){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("ruslatunna1907@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);


        return "redirect:/";
    }

}
