package project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.persistence.entities.Ad;
import project.service.UserService;
import project.service.AdService;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


@Controller
public class HomeController {

    // Instance Variables
    private AdService adService;
    private UserService userService;

    // Dependency Injection
    @Autowired
    public HomeController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession httpSession){

        Date currentDate = new Date();

        model.addAttribute("userID", httpSession.getAttribute("currentUser"));
        model.addAttribute("userName", httpSession.getAttribute("currentUsername"));
        model.addAttribute("userOrgi", httpSession.getAttribute("currentUserOrgi"));
        model.addAttribute("ad_list", adService.findAllActive(currentDate));
        model.addAttribute("header_type", "red_bar");

        return "Home";
    }

    @RequestMapping(value = "/organizations" , method = RequestMethod. GET)
    public String viewOrganizations(Model model) {
        // Get list of organizations and send to view
        Map<Long, String> organizationList = new LinkedHashMap<Long, String>();
        List<User> users = userService.findAllByOrderByNameAsc();
        List<User> organization_list = new ArrayList<User>();

        if(users.size() > 0) {
            for (int i=0; i<users.size(); i++) {
                if(users.get(i).getOrgi()) {
                    organizationList.put(users.get(i).getId(), users.get(i).getName());
                    organization_list.add(users.get(i));
                }
            }
        }

        model.addAttribute("organization_list", organization_list);
        model.addAttribute("organizationValues", organizationList.values());

        return "Organizations";
    }
}