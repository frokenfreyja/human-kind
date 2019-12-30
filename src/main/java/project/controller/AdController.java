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
import org.springframework.mail.javamail.JavaMailSender;
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
    private JavaMailSender javaMailSender;

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
        model.addAttribute("work_list", workService.findAllActive(currentDate));

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
        String genLoc = work.getGeneralLoc(work.getZipcode());
        work.setGenLoc(genLoc);

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

    @RequestMapping(value = "/ad/{id}/edit_ad", method = RequestMethod.GET)
    public String editAd(@PathVariable Long id, Work work, Model model, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");

        if(userID == null) {
            return "redirect:/login";
        }

        Work ad = workService.findOne(id);

        if(!ad.getOwner().equals(userID))
            return "redirect:/ad/{id}";

        model.addAttribute("ad", ad);

        return "AdEdit";
    }

    @RequestMapping(value = "/ad/{id}/edit_ad", method = RequestMethod.POST)
    public String editAdPost(@PathVariable Long id, Work work, Model model, HttpSession httpSession, HttpServletRequest httpServletRequest) throws IOException {
        Long userID = (Long) httpSession.getAttribute("currentUser");

        if(userID == null) {
            return "redirect:/login";
        }

        Work ad = workService.findOne(id);

        if(!ad.getOwner().equals(userID))
            return "redirect:/ad/{id}";

        System.out.println("test");
        System.out.println(work.toString());

        ad.setName(work.getName());
        ad.setDate(work.getDate());
        ad.setInterest(work.getInterest());
        ad.setLocation(work.getLocation());
        ad.setZipcode(work.getZipcode());
        ad.setDescription(work.getDescription());

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

        if (work.getImageName() != null) {
            ad.setImageName(work.getImageName());
        }

        workService.save(ad);

        return "redirect:/ad/{id}";
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

    @RequestMapping(value = "ad/{id}/{userid}/reject", method = RequestMethod.GET)
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