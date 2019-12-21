package project.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.Applicant;
import project.persistence.entities.Work;
import project.persistence.entities.User;
import project.service.ApplicantService;
import project.service.UserService;
import project.service.WorkService;

@Controller
public class AdController {

    // Instance Variables
    private WorkService workService;
    private UserService userService;
    private ApplicantService applicantService;

    /*
     * MUNA AÐ SETJA NÝ SERVICE Í SMIÐ
     */
    @Autowired
    public AdController(WorkService workService, UserService userService, ApplicantService applicantService) {
        this.workService = workService;
        this.userService = userService;
        this.applicantService = applicantService;
    }

    @RequestMapping(value = "/all_ads", method = RequestMethod.GET)
    public String viewAllAds(Model model, HttpSession httpSession) {

        Date currentDate = new Date();

        model.addAttribute("work", new Work());
        //model.addAttribute("work_list", workService.findAllReverseOrder());
        model.addAttribute("work_list", workService.findAllActive(currentDate));
        httpSession.removeAttribute("interest");
        httpSession.removeAttribute("organization");

        // Get list of organizations and send to view
        Map<Long, String> organizationList = new LinkedHashMap<Long, String>();
        List<User> users = userService.findAllByOrderByNameAsc();
        for (int i=0; i<users.size(); i++) {
            if(users.get(i).getOrgi()) {
                organizationList.put(users.get(i).getId(), users.get(i).getName());
            }
        }
        model.addAttribute("organizationValues", organizationList.values());

        return "AllAds";
    }

    /**
     * Search for ads that contain search word in title or description
     */
    @RequestMapping(value = "searchlistx", method = RequestMethod.GET)
    public String searchItems(@RequestParam (value = "searching", required = false) String searchwords, Model model) {

        model.addAttribute("work", new Work());
        model.addAttribute("work_list", workService.findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(searchwords, searchwords));

        return "AllAds";
    }

    @RequestMapping(value = "sortcategory" , method = RequestMethod. POST)
    public String selectInterest(@RequestParam("interest") String interest, @RequestParam("organization") String organization, @ModelAttribute("work") Work work, HttpSession httpSession, Model model)
    {
        httpSession.setAttribute("interest", interest);
        if (interest.equals("All") || interest.equals("Category")) {
            httpSession.removeAttribute("interest");
        }

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
        String zip = (String)httpSession.getAttribute("zip");
        String orgi = (String) httpSession.getAttribute("organization");

        if ((interest != null) && (orgi == null)) {
            System.out.println("1: " + interest + " : " + orgi);
            model.addAttribute("work_list", workService.findByInterestReverseOrder(interest));
        } else if ((orgi != null) && (interest == null)) {
            System.out.println("2: " + interest + " : " + orgi);
            model.addAttribute("work_list", workService.findByOrganization(orgi));
        } else if((orgi != null) && (interest != null)) {
            System.out.println("3: " + interest + " : " + orgi);
            model.addAttribute("work_list", workService.findByOrOrganizationAndInterest(orgi, interest));
        } else {
            System.out.println("4: " + interest + " : " + orgi);
            model.addAttribute("work",new Work());
            model.addAttribute("work_list", workService.findAllReverseOrder());
        }

         return "AllAds";
    }

    @RequestMapping(value = "/new_ad", method = RequestMethod.GET)
    public String newAdForm(Model model, HttpSession httpSession) {

        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null) {
            return "redirect:/login";
        }
        User currUser = userService.findOne(userID);

        model.addAttribute("work", new Work());
        model.addAttribute("work_list", workService.findAllReverseOrder());
        model.addAttribute("header_type", "red_bar");
        model.addAttribute("currUser", currUser);

        return "NewAd";
    }

    @RequestMapping(value = "/new_ad", method = RequestMethod.POST)
    public String newItem(@ModelAttribute("work") Work work, Model model, HttpServletRequest httpServletRequest, HttpSession httpSession) throws IOException {

        Long userID = (Long) httpSession.getAttribute("currentUser");
        work.setOwner(userID);

        if (userID == null) {
            return "redirect:/login";
        }

        User currUser = userService.findOne(userID);
        work.setOrganization(currUser.getName());

        MultipartFile imagefile = work.getImage();
        String fileName;

        imagefile.getInputStream();

        if (work.getImage()==null) throw new NullPointerException("unable to fetch"+imagefile);
        String rootDirectory = httpServletRequest.getSession().getServletContext().getRealPath("/");
        if(work.getImage() != null && !work.getImage().isEmpty())
            try {
                File path = new File(rootDirectory + "resources/images/"+imagefile.getOriginalFilename());
                imagefile.transferTo(path);

                fileName = imagefile.getOriginalFilename();
                work.setImageName(fileName);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }

        if (work.getImageName() == null) {
            work.setImageName(currUser.getImageName());
        }

        workService.save(work);
        model.addAttribute("work_list", workService.findAllReverseOrder());
        model.addAttribute("work", new Work());

        return "redirect:/";
    }

    @RequestMapping(value = "/ad/{id}/delete", method = RequestMethod.GET)
    public String deleteAd(@PathVariable Long id, Work work, Model model, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Work ad = workService.findOne(id);
        if(ad != null) {
            workService.delete(ad);

            // Delete all applicants of ad
            ArrayList<Applicant> applicants = applicantService.findAllApplicants(ad.getId());
            if(applicants.size() != 0) {
                for (Applicant applicant : applicants) {
                    applicantService.delete(applicant);
                }
            }
        }

        return "redirect:/";
    }

    //@RequestMapping
    public String editAd(Work work, Model model) {
        return "";
    }

    @RequestMapping(value = "/ad/{id}", method = RequestMethod.GET)
    public String viewAd(@PathVariable Long id, Model model, HttpSession httpSession) {
        Work ad = new Work();
        ad = workService.findOne(id);
        User owner = userService.findOne(ad.getOwner());
        ArrayList<Applicant> applicantList = applicantService.findAllApplicants(id);
        ArrayList<User> userList = new ArrayList<User>(applicantList.size());
        for (Applicant applicant : applicantList) userList.add(userService.findOne(applicant.getUser()));

        Long userID = (Long) httpSession.getAttribute("currentUser");
        User currUser = userService.findOne(userID);

        model.addAttribute("ad", ad);
        model.addAttribute("owner", owner);
        model.addAttribute("currUser", currUser);
        model.addAttribute("genLoc", ad.getGeneralLoc(ad.getZipcode()));

        if(currUser != null && applicantService.findByWorkAndUser(ad.getId(), currUser.getId()) != null) {
            model.addAttribute("alreadyApplied", true);
        }

        if(owner == currUser) {
            model.addAttribute("applicants", userList);
            model.addAttribute("accepted", applicantList);
        }

        return "AdDetail";
    }

    @RequestMapping(value = "/ad/{id}/apply", method = RequestMethod.GET)
    public String register(@PathVariable Long id, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Applicant applicant = new Applicant();
        applicant.setWork(id);
        applicant.setUser(userID);

        if(applicantService.findByWorkAndUser(id,userID) == null) {
            applicantService.save(applicant);
        }

        return "redirect:/ad/{id}";
    }

    @RequestMapping(value = "/ad/{id}/unapply", method = RequestMethod.GET)
    public String deregister(@PathVariable Long id, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Applicant applicant = applicantService.findByWorkAndUser(id, userID);
        if(applicant != null) {
            applicantService.delete(applicant);
        }

        return "redirect:/ad/{id}";
    }

    @RequestMapping(value = "/ad/{id}/{userid}/accept", method = RequestMethod.GET)
    public String acceptApplicant(@PathVariable Long id, @PathVariable Long userid, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Applicant applicant = applicantService.findByWorkAndUser(id,userid);

        applicant.setAccepted(true);

        applicantService.save(applicant);

        return "redirect:/ad/{id}";
    }

    @RequestMapping(value = "ad/{id}/{userid}/reject")
    public String rejectApplicant(@PathVariable Long id, @PathVariable Long userid, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Applicant applicant = applicantService.findByWorkAndUser(id,userid);

        applicant.setAccepted(false);

        applicantService.save(applicant);

        return "redirect:/ad/{id}";
    }
}