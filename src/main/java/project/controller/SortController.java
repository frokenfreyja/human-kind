package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.User;
import project.persistence.entities.Work;
import project.service.ApplicantService;
import project.service.UserService;
import project.service.WorkService;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SortController {

    // Instance Variables
    private WorkService workService;
    private UserService userService;

    // Dependency Injection
    @Autowired
    public SortController(WorkService workService, UserService userService) {
        this.workService = workService;
        this.userService = userService;
    }

    /**
     * Search for ads that contain search word in title or description
     */
    @RequestMapping(value = "searchlistx", method = RequestMethod.GET)
    public String searchItems(@RequestParam(value = "searching", required = false) String searchwords, Model model) {

        model.addAttribute("work", new Work());
        model.addAttribute("work_list", workService.findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(searchwords, searchwords));

        return "AllAds";
    }

    @RequestMapping(value = "sortcat" , method = RequestMethod. POST)
    public String sortCat(@RequestParam("interest") String interest, @ModelAttribute("work") Work work, HttpSession httpSession, Model model)
    {
        httpSession.setAttribute("interest", interest);
        if (interest.equals("All") || interest.equals("Category")) {
            httpSession.removeAttribute("interest");
        }

        return "redirect:sorter";
    }

    @RequestMapping(value = "sortloc" , method = RequestMethod. POST)
    public String sortLoc(@RequestParam("genLoc") String genLoc, @ModelAttribute("work") Work work, HttpSession httpSession, Model model)
    {
        httpSession.setAttribute("genLoc", genLoc);
        if(genLoc.equals("All") || genLoc.equals("Location")) {
            httpSession.removeAttribute("genLoc");
        }

        return "redirect:sorter";
    }

    @RequestMapping(value = "sortorg" , method = RequestMethod. POST)
    public String sortOrg(@RequestParam("organization") String organization, @ModelAttribute("work") Work work, HttpSession httpSession, Model model)
    {
        httpSession.setAttribute("organization", organization);
        if (organization.equals("All") || organization.equals("Organization")) {
            httpSession.removeAttribute("organization");
        }

        return "redirect:sorter";
    }

    @RequestMapping(value = "sorter" , method = RequestMethod. GET)
    public String sortZipTag(HttpSession httpSession, Model model, Work work) {

        // Get list of organizations and send to view
        Map<Long, String> organizationList = new LinkedHashMap<Long, String>();
        List<User> users = userService.findAllByOrderByNameAsc();
        for (int i=0; i<users.size(); i++) {
            if(users.get(i).getOrgi()) {
                organizationList.put(users.get(i).getId(), users.get(i).getName());
            }
        }
        model.addAttribute("organizationValues", organizationList.values());

        // Sort by functionality
        String interest = (String)httpSession.getAttribute("interest");
        String genLoc = (String)httpSession.getAttribute("genLoc");
        String orgi = (String) httpSession.getAttribute("organization");


        if ((interest != null) && (orgi == null) && (genLoc == null)) {
            model.addAttribute("work_list", workService.findByInterestReverseOrder(interest));
        } else if ((orgi != null) && (interest == null) && (genLoc == null)) {
            model.addAttribute("work_list", workService.findByOrganization(orgi));
        } else if ((genLoc != null) && (orgi == null) && (interest == null)) {
            model.addAttribute("work_list", workService.findByGenLoc(genLoc));
        } else if ((orgi != null) && (interest != null) && (genLoc == null)) {
            model.addAttribute("work_list", workService.findByOrganizationAndInterest(orgi, interest));
        } else if ((orgi != null) && (genLoc != null) && (interest == null)) {
            model.addAttribute("work_list", workService.findByOrganizationAndGenLoc(orgi, genLoc));
        } else if ((interest != null) && (genLoc != null) && (orgi == null)) {
            model.addAttribute("work_list", workService.findByInterestAndGenLoc(interest, genLoc));
        } else if ((orgi != null) && (interest != null) && (genLoc != null)) {
            model.addAttribute("work_list", workService.findByOrganizationAndInterestAndGenLoc(orgi, interest, genLoc));
        } else {
            model.addAttribute("work",new Work());
            model.addAttribute("work_list", workService.findAllReverseOrder());
        }

        return "AllAds";
    }

}