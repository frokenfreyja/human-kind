package project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.Applicant;
import project.persistence.entities.Ad;
import project.persistence.entities.User;
import project.service.ApplicantService;
import project.service.EmailService;
import project.service.UserService;
import project.service.AdService;

@Controller
public class AdController {

    // Instance Variables
    private AdService adService;
    private UserService userService;
    private ApplicantService applicantService;
    private EmailService emailService;

    /*
     * MUNA AÐ SETJA NÝ SERVICE Í SMIÐ
     */
    @Autowired
    public AdController(AdService adService, UserService userService, ApplicantService applicantService, EmailService emailService) {
        this.adService = adService;
        this.userService = userService;
        this.applicantService = applicantService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/all_ads", method = RequestMethod.GET)
    public String viewAllAds(Model model, HttpSession httpSession) {

        Date currentDate = new Date();

        model.addAttribute("ad", new Ad());
        model.addAttribute("ad_list", adService.findAllActive(currentDate));

        httpSession.removeAttribute("interest");
        httpSession.removeAttribute("organization");
        httpSession.removeAttribute("genLoc");

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

    @RequestMapping(value = "/new_ad", method = RequestMethod.GET)
    public String newAdForm(Model model, HttpSession httpSession) {

        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null) {
            return "redirect:/login";
        }
        User currUser = userService.findOne(userID);

        model.addAttribute("ad", new Ad());
        model.addAttribute("ad_list", adService.findAllReverseOrder());
        model.addAttribute("header_type", "red_bar");
        model.addAttribute("currUser", currUser);

        return "NewAd";
    }

    @RequestMapping(value = "/new_ad", method = RequestMethod.POST)
    public String newItem(@ModelAttribute("ad") Ad ad, Model model, HttpServletRequest httpServletRequest, HttpSession httpSession) throws IOException {

        Long userID = (Long) httpSession.getAttribute("currentUser");
        ad.setOwner(userID);

        if (userID == null) {
            return "redirect:/login";
        }

        User currUser = userService.findOne(userID);
        ad.setOrganization(currUser.getName());

        MultipartFile imagefile = ad.getImage();
        String fileName;

        imagefile.getInputStream();

        if (ad.getImage()==null) throw new NullPointerException("unable to fetch"+imagefile);
        String rootDirectory = httpServletRequest.getSession().getServletContext().getRealPath("/");
        if(ad.getImage() != null && !ad.getImage().isEmpty())
            try {
                File path = new File(rootDirectory + "resources/images/"+imagefile.getOriginalFilename());
                imagefile.transferTo(path);

                fileName = imagefile.getOriginalFilename();
                ad.setImageName(fileName);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }

        if (ad.getImageName() == null) {
            ad.setImageName(currUser.getImageName());
        }
        String genLoc = ad.getGeneralLoc(ad.getZipcode());
        ad.setGenLoc(genLoc);

        adService.save(ad);
        model.addAttribute("ad_list", adService.findAllReverseOrder());
        model.addAttribute("ad", new Ad());

        return "redirect:/";
    }

    @RequestMapping(value = "/ad/{id}/delete", method = RequestMethod.GET)
    public String deleteAd(@PathVariable Long id, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Ad ad = adService.findOne(id);
        if(ad != null) {
            adService.delete(ad);

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

    @RequestMapping(value = "/ad/{id}/edit_ad", method = RequestMethod.GET)
    public String editAd(@PathVariable Long id, Model model, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");

        if(userID == null) {
            return "redirect:/login";
        }

        Ad ad = adService.findOne(id);

        if(!ad.getOwner().equals(userID))
            return "redirect:/ad/{id}";

        model.addAttribute("ad", ad);

        return "AdEdit";
    }



    @RequestMapping(value = "/ad/{id}/edit_ad", method = RequestMethod.POST)
    public String editAdPost(@PathVariable Long id, Ad ad, Model model, HttpSession httpSession, HttpServletRequest httpServletRequest) throws IOException {
        Long userID = (Long) httpSession.getAttribute("currentUser");

        if(userID == null) {
            return "redirect:/login";
        }

        Ad edit_ad = adService.findOne(id);

        if(!edit_ad.getOwner().equals(userID))
            return "redirect:/ad/{id}";

        edit_ad.setName(ad.getName());
        edit_ad.setDate(ad.getDate());
        edit_ad.setInterest(ad.getInterest());
        edit_ad.setLocation(ad.getLocation());
        edit_ad.setZipcode(ad.getZipcode());
        edit_ad.setDescription(ad.getDescription());
        edit_ad.setMsg(ad.getMsg());

        MultipartFile imagefile = ad.getImage();
        String fileName;

        imagefile.getInputStream();

        if (ad.getImage()==null) throw new NullPointerException("unable to fetch"+imagefile);
        String rootDirectory = httpServletRequest.getSession().getServletContext().getRealPath("/");
        if(ad.getImage() != null && !ad.getImage().isEmpty())
            try {
                File path = new File(rootDirectory + "resources/images/"+imagefile.getOriginalFilename());
                imagefile.transferTo(path);

                fileName = imagefile.getOriginalFilename();
                ad.setImageName(fileName);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }

        if (ad.getImageName() != null) {
            edit_ad.setImageName(ad.getImageName());
        }

        adService.save(edit_ad);

        return "redirect:/ad/{id}";
    }

    @RequestMapping(value = "/ad/{id}/close", method = RequestMethod.GET)
    public String closeAd(@PathVariable Long id, Model model, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if (userID == null) {
            return "redirect:/login";
        }

        Ad ad = adService.findOne(id);
        ad.setClosed(true);

        adService.save(ad);

        return "redirect:/ad/{id}";
    }

    @RequestMapping(value = "/ad/{id}", method = RequestMethod.GET)
    public String viewAd(@PathVariable Long id, Model model, HttpSession httpSession) {
        Ad ad = new Ad();
        ad = adService.findOne(id);
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

        if(currUser != null && applicantService.findByAdAndUser(ad.getId(), currUser.getId()) != null) {
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
        applicant.setAd(id);
        applicant.setUser(userID);

        if(applicantService.findByAdAndUser(id,userID) == null) {
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

        Applicant applicant = applicantService.findByAdAndUser(id, userID);
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

        Applicant applicant = applicantService.findByAdAndUser(id,userid);

        applicant.setAccepted(true);

        applicantService.save(applicant);

        emailService.sendAcceptMail(userService.findOne(userid), adService.findOne(id).getMsg());

        return "redirect:/ad/{id}";
    }

    @RequestMapping(value = "ad/{id}/{userid}/reject", method = RequestMethod.GET)
    public String rejectApplicant(@PathVariable Long id, @PathVariable Long userid, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Applicant applicant = applicantService.findByAdAndUser(id,userid);

        applicant.setAccepted(false);

        applicantService.save(applicant);

        return "redirect:/ad/{id}";
    }
}