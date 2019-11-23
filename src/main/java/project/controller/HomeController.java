package project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Work;
import project.service.WorkService;
import java.util.List;


@Controller
public class HomeController {

    // Instance Variables
    private WorkService workService;

    // Dependency Injection
    @Autowired
    public HomeController(WorkService workService) {
        this.workService = workService;
    }

    //@RequestMapping
    public String home(Work work, Model model) {
        return "";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String workList(Model model, HttpSession httpSession){

        model.addAttribute("userID", httpSession.getAttribute("currentUser"));
        model.addAttribute("userName", httpSession.getAttribute("currentUsername"));
        model.addAttribute("userOrgi", httpSession.getAttribute("currentUserOrgi"));
        model.addAttribute("work_list", workService.findAllReverseOrder());
        model.addAttribute("header_type", "red_bar");

        System.out.println("currentUser: " + httpSession.getAttribute("currentUsername"));
        return "Home";
    }

    @RequestMapping(value = "/all_ads", method = RequestMethod.GET)
    public String viewAllAds(Model model, HttpSession httpSession){

        model.addAttribute("work_list", workService.findAllReverseOrder());

        return "AllAds";
    }

}