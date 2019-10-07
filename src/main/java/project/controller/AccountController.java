package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.UserService;

@Controller
public class AccountController {

    // Instance Variables
    private UserService userService;

    // Dependency Injection
    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGet(Model model) {
        //model.addAttribute("user", new User());

        return "SignUp";
    }

    //@RequestMapping
    public String createAccount(User user, Model model) {
        return "";
    }

    //@RequestMapping
    public String deleteAccount(User user, Model model) {
        return "";
    }
}
