package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.Applicant;
import project.persistence.entities.User;
import project.persistence.entities.Work;
import project.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import project.service.WorkService;
import project.service.ApplicantService;


@Controller
public class AccountController {

    // Instance Variables
    private UserService userService;
    private WorkService workService;
    private ApplicantService applicantService;

    // Dependency Injection
    @Autowired
    public AccountController(UserService userService, WorkService workService, ApplicantService applicantService) {

        this.userService = userService;
        this.workService = workService;
        this.applicantService = applicantService;
    }

    @RequestMapping(value ="/user", method = RequestMethod.GET)
    public String accountView(@ModelAttribute("user") User user, Model model, HttpSession session){

        Long userID = (Long)session.getAttribute("currentUser");

        if(userID==null){
            return "redirect:/login";
        }

        user = userService.findOne(userID);
        model.addAttribute("user", user);

        ArrayList<Work> jobs = new ArrayList<>(user.getJobs().size());
        for(int i = 0; i<user.getJobs().size(); i++) {
            jobs.add(workService.findOne(user.getJobs().get(i)));
        }
        model.addAttribute("jobs", jobs);
        model.addAttribute("own_ads", workService.findByOwner(user.getId()));

        return "User";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String createAccountGet(Model model) {

        model.addAttribute("user", new User());

        return "SignUp";
    }

    @RequestMapping(value = "/org", method = RequestMethod.GET)
    public String createAsOrg(Model model) {

        model.addAttribute("user", new User());

        return "SignUpOrg";
    }

    @RequestMapping(value = "/org", method = RequestMethod.POST)
    public String createAsOrgPost(@ModelAttribute("user") User user, Model model, HttpServletRequest httpServletRequest){
        MultipartFile imagefile = user.getImage();
        String fileName;

        try {
            imagefile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(user.getImage()==null) throw new NullPointerException("unable to get" + imagefile);

        String rootDir = httpServletRequest.getSession().getServletContext().getRealPath("/");
        if(user.getImage() != null && !user.getImage().isEmpty()) {
            try {

                File path = new File(rootDir + "resources/images/" + imagefile.getOriginalFilename());
                imagefile.transferTo(path);

                fileName = imagefile.getOriginalFilename();
                user.setImageName(fileName);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "A user with the email address " + user.getEmail() + " already exists");
        } else if(!(user.getPassword().equals(user.getConfirmPassword()))) {
            model.addAttribute("error", "Passwords don't match.");
        } else {
            user.setOrgi(true);
            userService.save(user);
            return "redirect:/login";
        }
        return "SignUpOrg";
    }

    @RequestMapping(value = "/vol", method = RequestMethod.GET)
    public String createAsVol(Model model) {

        model.addAttribute("user", new User());

        return "SignUpVol";
    }

    @RequestMapping(value = "/vol", method = RequestMethod.POST)
    public String createAsVolPost(@ModelAttribute("user") User user, Model model, HttpServletRequest httpServletRequest){
        MultipartFile imagefile = user.getImage();
        String fileName;

        try {
            imagefile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(user.getImage()==null) throw new NullPointerException("unable to get" + imagefile);

        String rootDir = httpServletRequest.getSession().getServletContext().getRealPath("/");
        if(user.getImage() != null && !user.getImage().isEmpty()) {
            try {

                File path = new File(rootDir + "resources/images/" + imagefile.getOriginalFilename());
                imagefile.transferTo(path);

                fileName = imagefile.getOriginalFilename();
                user.setImageName(fileName);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "A user with the email address " + user.getEmail() + " already exists");
        } else if(!(user.getPassword().equals(user.getConfirmPassword()))) {
            model.addAttribute("error", "Passwords don't match.");
        } else {
            user.setOrgi(false);
            userService.save(user);
            return "redirect:/login";
        }
        return "SignUpVol";
    }

    //@RequestMapping
    public String deleteAccount(User user, Model model) {
        return "";
    }
}
