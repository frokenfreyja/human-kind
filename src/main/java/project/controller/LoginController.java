package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.persistence.entities.User;
import project.service.UserService;

import javax.servlet.http.HttpSession;


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
        model.addAttribute("header_type", "red_bar");

        return "Login";
    }

    //Login process
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(User user, HttpSession httpSession, Model model, RedirectAttributes redirectAttrs) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(!user.getEmail().isEmpty()) {
            User loginUser = userService.findByEmail(user.getEmail());

            if(loginUser != null && bCryptPasswordEncoder.matches(user.getPassword(), loginUser.getPassword()) && loginUser.isEnabled()){
                httpSession.setAttribute("currentUser", loginUser.getId());
                httpSession.setAttribute("currentUsername", loginUser.getName());
                httpSession.setAttribute("currentUserEmail", loginUser.getEmail());
                httpSession.setAttribute("currentUserOrgi", loginUser.getOrgi());
                redirectAttrs.addAttribute("id", loginUser.getId());
                return "redirect:/user/{id}";
            } else if (loginUser == null) {
                model.addAttribute("loginDenied", "This account does not exist");
            } else if(!loginUser.isEnabled()) {
                model.addAttribute("loginDenied", "This account hasn't been activated. A verification email has been sent to: " + loginUser.getEmail());
            } else {
                model.addAttribute("loginDenied", "The email or password you entered is incorrect");
            }
        }
        model.addAttribute("header_type", "red_bar");

        return "Login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {

        session.removeAttribute("currentUser");

        return "redirect:/";
    }
}
