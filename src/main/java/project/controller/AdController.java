package project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import project.persistence.entities.Work;
import project.persistence.entities.User;
import project.service.ApplicantService;
import project.service.UserService;
import project.service.WorkService;
import java.util.Date;


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

    @RequestMapping(value = "/new_ad", method = RequestMethod.GET)
    public String newAdForm(Model model, HttpSession httpSession) {

        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null) {
            return "redirect:/login";
        }

        model.addAttribute("work", new Work());
        model.addAttribute("work_list", workService.findAllReverseOrder());

        return "NewAd1";
    }

    @RequestMapping(value = "/new_ad", method = RequestMethod.POST)
    public String newItem1(@ModelAttribute("work") Work work, Model model, HttpServletRequest httpServletRequest, HttpSession httpSession) throws IOException {

        Long userID = (Long) httpSession.getAttribute("currentUser");
        work.setOwner(userID);

        httpSession.setAttribute("ad_name", work.getName());
        httpSession.setAttribute("ad_desc", work.getDescription());
        httpSession.setAttribute("ad_date", work.getDate());
        httpSession.setAttribute("ad_cat", work.getInterest());

        return "NewAd2";
    }

    @RequestMapping(value = "/new_ad/2", method = RequestMethod.POST)
    public String newItem2(@ModelAttribute("work") Work work, Model model, HttpServletRequest httpServletRequest, HttpSession httpSession) throws IOException {

        Long userID = (Long) httpSession.getAttribute("currentUser");

        String name = (String) httpSession.getAttribute("ad_name");
        String desc = (String) httpSession.getAttribute("ad_desc");
        Date date = (Date) httpSession.getAttribute("ad_date");
        String cat = (String) httpSession.getAttribute("ad_cat");


        if (userID == null) {
            return "redirect:/login";
        }

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

        work.setOwner(userID);
        work.setName(name);
        work.setDescription(desc);
        work.setDate(date);
        work.setInterest(cat);

        workService.save(work);
        model.addAttribute("work_list", workService.findAllReverseOrder());
        model.addAttribute("work", new Work());

        return "redirect:/";
    }

    //@RequestMapping
    public String deleteAd(Work work, Model model) {
        return "";
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
        ArrayList<Applicant> app = applicantService.findAllApplicants(id);
        ArrayList<User> use = new ArrayList<User>(app.size());
        for (Applicant applicant : app) use.add(userService.findOne(applicant.getUser()));

        Long userID = (Long) httpSession.getAttribute("currentUser");
        User currUser = userService.findOne(userID);

        model.addAttribute("ad", ad);
        model.addAttribute("owner", owner);
        model.addAttribute("currUser", currUser);

        if(owner == currUser) {
            model.addAttribute("applicants", use);
        }

        return "AdDetail";
    }

    @RequestMapping(value = "/ad/{id}/apply", method = RequestMethod.GET)
    public String register(@PathVariable Long id,  Work work, User user, Model model, HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Applicant applicant = new Applicant();
        applicant.setWork(id);
        applicant.setUser(userID);

        System.out.println("JOB ID: " + id);
        User currUser = userService.findOne(userID);
        currUser.setJobs(id);

        if(applicantService.findByWorkAndUser(id,userID).size() == 0) {
            applicantService.save(applicant);
            userService.save(currUser);
        }

        return "redirect:/ad/{id}";
    }

    @RequestMapping(value = "/ad/{id}/unapply", method = RequestMethod.GET)
    public String deregister(@PathVariable Long id,  Work work, User user, Model model, HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        if(userID == null){
            return "redirect:/login";
        }

        Applicant applicant = new Applicant();
        applicant.setWork(id);
        applicant.setUser(userID);
        if(applicantService.findByWorkAndUser(id,userID).size() > 0)
            applicantService.delete(applicant);
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