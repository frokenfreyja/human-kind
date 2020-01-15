package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.User;
import project.persistence.entities.Ad;
import project.service.UserService;
import project.service.AdService;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SortController {

    // Instance Variables
    private AdService adService;
    private UserService userService;

    // Dependency Injection
    @Autowired
    public SortController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    /**
     * Search for ads that contain search word in title or description
     */
    @RequestMapping(value = "searchlistx", method = RequestMethod.GET)
    public String searchItems(@RequestParam(value = "searching", required = false) String searchwords, Model model) {

        model.addAttribute("header_type", "red_bar");
        model.addAttribute("ad", new Ad());
        model.addAttribute("ad_list", adService.findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(searchwords, searchwords));

        return "AllAds";
    }

    @RequestMapping(value = "sortcat" , method = RequestMethod. POST)
    public String catSort(@RequestParam("interest") String interest, @ModelAttribute("ad") Ad ad, HttpSession httpSession)
    {
        httpSession.setAttribute("interest", interest);
        if (interest.equals("All") || interest.equals("Category")) {
            httpSession.removeAttribute("interest");
        }

        return "redirect:sorter";
    }

    @RequestMapping(value = "sortloc" , method = RequestMethod. POST)
    public String locSort(@RequestParam("genLoc") String genLoc, @ModelAttribute("ad") Ad ad, HttpSession httpSession)
    {
        httpSession.setAttribute("genLoc", genLoc);
        if(genLoc.equals("All") || genLoc.equals("Location")) {
            httpSession.removeAttribute("genLoc");
        }

        return "redirect:sorter";
    }

    @RequestMapping(value = "sortorg" , method = RequestMethod. POST)
    public String orgSort(@RequestParam("organization") String organization, @ModelAttribute("ad") Ad ad, HttpSession httpSession)
    {
        httpSession.setAttribute("organization", organization);
        if (organization.equals("All") || organization.equals("Organization")) {
            httpSession.removeAttribute("organization");
        }

        return "redirect:sorter";
    }

    @RequestMapping(value = "sorter" , method = RequestMethod. GET)
    public String allSort(HttpSession httpSession, Model model) {
        model.addAttribute("ad", new Ad());

        // Get list of organizations and send to view
        Map<Long, String> organizationList = new LinkedHashMap<Long, String>();
        List<User> users = userService.findAllByOrderByNameAsc();
        for (int i=0; i<users.size(); i++) {
            if(users.get(i).getOrgi()) {
                organizationList.put(users.get(i).getId(), users.get(i).getName());
            }
        }
        model.addAttribute("header_type", "red_bar");
        model.addAttribute("organizationValues", organizationList.values());

        // Sort by functionality
        String interest = (String)httpSession.getAttribute("interest");
        String genLoc = (String)httpSession.getAttribute("genLoc");
        String orgi = (String) httpSession.getAttribute("organization");


        if ((interest != null) && (orgi == null) && (genLoc == null)) {
            model.addAttribute("ad_list", adService.findByInterestReverseOrder(interest));
        } else if ((orgi != null) && (interest == null) && (genLoc == null)) {
            model.addAttribute("ad_list", adService.findByOrganization(orgi));
        } else if ((genLoc != null) && (orgi == null) && (interest == null)) {
            model.addAttribute("ad_list", adService.findByGenLoc(genLoc));
        } else if ((orgi != null) && (interest != null) && (genLoc == null)) {
            model.addAttribute("ad_list", adService.findByOrganizationAndInterest(orgi, interest));
        } else if ((orgi != null) && (genLoc != null) && (interest == null)) {
            model.addAttribute("ad_list", adService.findByOrganizationAndGenLoc(orgi, genLoc));
        } else if ((interest != null) && (genLoc != null) && (orgi == null)) {
            model.addAttribute("ad_list", adService.findByInterestAndGenLoc(interest, genLoc));
        } else if ((orgi != null) && (interest != null) && (genLoc != null)) {
            model.addAttribute("ad_list", adService.findByOrganizationAndInterestAndGenLoc(orgi, interest, genLoc));
        } else {
            model.addAttribute("ad", new Ad());
            model.addAttribute("ad_list", adService.findAllReverseOrder());
        }

        return "AllAds";
    }

}