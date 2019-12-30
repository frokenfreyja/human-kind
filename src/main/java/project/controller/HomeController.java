package project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.persistence.entities.Work;
import project.service.UserService;
import project.service.WorkService;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


@Controller
public class HomeController {

    // Instance Variables
    private WorkService workService;
    private UserService userService;

    // Dependency Injection
    @Autowired
    public HomeController(WorkService workService, UserService userService) {
        this.workService = workService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String workList(Model model, HttpSession httpSession){

        Date currentDate = new Date();

        model.addAttribute("userID", httpSession.getAttribute("currentUser"));
        model.addAttribute("userName", httpSession.getAttribute("currentUsername"));
        model.addAttribute("userOrgi", httpSession.getAttribute("currentUserOrgi"));
        model.addAttribute("work_list", workService.findAllActive(currentDate));
        model.addAttribute("header_type", "red_bar");

        return "Home";
    }

    @RequestMapping(value = "/organizations" , method = RequestMethod. GET)
    public String viewOrganizations(HttpSession httpSession, Model model, Work work) {
        // Get list of organizations and send to view
        Map<Long, String> organizationList = new LinkedHashMap<Long, String>();
        List<User> users = userService.findAllByOrderByNameAsc();
        List<User> organization_list = new ArrayList<User>();
        for (int i=0; i<users.size(); i++) {
            if(users.get(i).getOrgi()) {
                organizationList.put(users.get(i).getId(), users.get(i).getName());
                organization_list.add(users.get(i));
            }
        }
        System.out.println("organization_list: " + organization_list.get(0).getName());

        model.addAttribute("organization_list", organization_list);
        model.addAttribute("organizationValues", organizationList.values());

        return "Organizations";
    }
}