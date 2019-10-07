package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Work;
import project.persistence.entities.User;
import project.service.UserService;
import project.service.WorkService;

@Controller
public class WorkController {

    // Instance Variables
    private WorkService workService;
    private UserService userService;

    // Dependency Injection
    @Autowired
    public WorkController(WorkService workService, UserService userService) {
        this.workService = workService;
        this.userService = userService;
    }

    //@RequestMapping(value = "/newad", method = RequestMethod.POST)
    public String newAd(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String deleteAd(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String editAd(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String viewAd(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String register(Work work, User user, Model model) {
        return "";
    }

    //@RequestMapping
    public String deregister(Work work, User user, Model model) {
        return "";
    }

    //@RequestMapping
    public String acceptApplicant(Work work, User user, Model model) {
        return "";
    }

    //@RequestMapping
    public String rejectApplicant(Work work, User user, Model model) {
        return "";
    }
}
