package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.StringManipulationService;
import project.service.UserService;

@Controller
public class HomeControllerGamla {

    // Instance Variables
    StringManipulationService stringService;
    UserService userService;

    // Dependency Injection
    @Autowired
    public HomeControllerGamla(StringManipulationService stringService) {
        this.stringService = stringService;
    }

    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080" into a browser, this
    // method is called
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){

        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Index" to something else, be sure you have a .jsp
        // file that has the same name
        return "Index";
    }

    // To call this method, enter "localhost:8080/user" into a browser
    /*@RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(@ModelAttribute("user") User user, Model model){

        return "User";
    }*/
}
