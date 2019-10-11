package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.UserService;


@Controller
public class LoginController {

    // Instance Variables
    private UserService userService;


    // Dependency Injection
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    //Login view
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(User user, Model model) {
        model.addAttribute("user", new User());

        return "Login";
    }

    //Login process
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(User user, Model model) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(!user.getEmail().isEmpty()) {
            System.out.println("yeo");
            User loginUser = userService.findByEmail(user.getEmail());
            
            if(loginUser != null && bCryptPasswordEncoder.matches(user.getPassword(), loginUser.getPassword())){
                return "redirect:/user";
            }
        }


        model.addAttribute("loginDenied", "Access Denied");

        return "Login";
    }

    //@RequestMapping
    public String logout() {
        return "";
    }
}
