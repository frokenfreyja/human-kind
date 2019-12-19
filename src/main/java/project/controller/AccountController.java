package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Dependency Injection
    @Autowired
    public AccountController(UserService userService, WorkService workService, ApplicantService applicantService) {

        this.userService = userService;
        this.workService = workService;
        this.applicantService = applicantService;
    }

    @RequestMapping(value ="/user/{id}", method = RequestMethod.GET)
    public String accountView(@PathVariable Long id, @ModelAttribute("user") User user, Model model, HttpSession session){

        Long userID = (Long)session.getAttribute("currentUser");
        User currUser = userService.findOne(userID);

        user = userService.findOne(id);
        model.addAttribute("user", user);

        // Get all of user's applications
        ArrayList<Work> jobs = new ArrayList<>(applicantService.findAllApplications(user.getId()).size());
        ArrayList<Applicant> applications = applicantService.findAllApplications(user.getId());
        for(int i=0; i<applications.size(); i++) {
            Long workID = applications.get(i).getWork();
            Work work = workService.findOne(workID);
            jobs.add(work);
        }

        if(!user.getOrgi()) {
            model.addAttribute("jobs", jobs);
        }

        if(user.getOrgi()) {
            model.addAttribute("organization", true);
            model.addAttribute("own_ads", workService.findByOwner(user.getId()));
        }

        model.addAttribute("currUser", currUser);

        return "User";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String createAccountGet(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("header_type", "red_bar");

        return "SignUp";
    }

    @RequestMapping(value = "/org", method = RequestMethod.GET)
    public String createAsOrg(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("header_type", "red_bar");

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
            model.addAttribute("header_type", "red_bar");
        } else if (userService.findByName(user.getName()) != null) {
            model.addAttribute("error", "An organization with the name " + user.getName() + " already exists");
            model.addAttribute("header_type", "red_bar");
        } else if(!(user.getPassword().equals(user.getConfirmPassword()))) {
            model.addAttribute("error", "Passwords don't match.");
            model.addAttribute("header_type", "red_bar");
        } else {
            user.setOrgi(true);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.save(user);
            return "redirect:/login";
        }
        return "SignUpOrg";
    }

    @RequestMapping(value = "/vol", method = RequestMethod.GET)
    public String createAsVol(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("header_type", "red_bar");

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
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.save(user);
            return "redirect:/login";
        }
        return "SignUpVol";
    }

    /*
     * Delete account - POST
     */
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable Long id, @ModelAttribute("user") User user, Model model, HttpSession httpSession) {
        Long userID = (Long)httpSession.getAttribute("currentUser");
        User currUser = userService.findOne(userID);
        // Delete user
        userService.delete(currUser);

        // Delete all of user's applications
        ArrayList<Applicant> applications = applicantService.findAllApplications(id);
        for (Applicant application : applications) applicantService.delete(application);

        // Delete all of user's ads
        List<Work> works = workService.findByOwner(currUser.getId());
        if(works.size() != 0) {
            for (Work work : works) {
                workService.delete(work);

                // Delete all applicants of user's ads
                ArrayList<Applicant> applicants = applicantService.findAllApplicants(work.getId());
                if(applicants.size() != 0) {
                    for (Applicant applicant : applicants) {
                        applicantService.delete(applicant);
                    }
                }
            }
        }

        httpSession.removeAttribute("currentUser");

        return "redirect:/";
    }

    /**
     * Edit account - GET
     */
    @RequestMapping(value ="/edit_user/{id}", method = RequestMethod.GET)
    public String editAccount(@PathVariable Long id, @ModelAttribute("user") User user, Model model, HttpSession session){

        Long userID = (Long)session.getAttribute("currentUser");
        User currUser = userService.findOne(userID);

        if(userID==null)
            return "Login";

        user = userService.findOne(id);
        model.addAttribute("user", user);

        // Get all of user's applications
        ArrayList<Work> jobs = new ArrayList<>(applicantService.findAllApplications(user.getId()).size());
        ArrayList<Applicant> applications = applicantService.findAllApplications(user.getId());
        for(int i=0; i<applications.size(); i++) {
            Long workID = applications.get(i).getWork();
            Work work = workService.findOne(workID);
            jobs.add(work);
        }

        if(!user.getOrgi()) {
            model.addAttribute("jobs", jobs);
        }

        if(user.getOrgi()) {
            model.addAttribute("organization", true);
            model.addAttribute("own_ads", workService.findByOwner(user.getId()));
        }

        model.addAttribute("edit", true);
        model.addAttribute("currUser", currUser);

        return "User";
    }
    /**
     * Edit account - POST
     */
    @RequestMapping(value = "/edit_user/{id}", method = RequestMethod.POST)
    public String editAccountPost(@PathVariable Long id, User user, Model model, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");
        User currUser = userService.findOne(userID);

        if(userID==null)
            return "Login";

        System.out.println(user.getId() + " : " + user.getName());

        model.addAttribute("currUser", currUser);

        // Get all of user's applications
        ArrayList<Work> jobs = new ArrayList<>(applicantService.findAllApplications(currUser.getId()).size());
        ArrayList<Applicant> applications = applicantService.findAllApplications(currUser.getId());
        for(int i=0; i<applications.size(); i++) {
            Long workID = applications.get(i).getWork();
            Work work = workService.findOne(workID);
            jobs.add(work);
        }

        if(!currUser.getOrgi()) {
            model.addAttribute("jobs", jobs);
        }

        if(currUser.getOrgi()) {
            model.addAttribute("organization", true);
            model.addAttribute("own_ads", workService.findByOwner(user.getId()));
        }

        if (userService.findByEmail(user.getEmail()) != null && !currUser.getEmail().equals(user.getEmail())) {
            model.addAttribute("error", "Email already exists");
            return "User";
        }

        currUser.setName(user.getName());
        currUser.setEmail(user.getEmail());
        currUser.setPhone(user.getPhone());
        currUser.setBirthDate(user.getBirthDate());
        currUser.setBio(user.getBio());

        httpSession.setAttribute("currentUser", currUser.getId());
        httpSession.setAttribute("currentUsername", currUser.getName());

        userService.save(currUser);

        return "redirect:/user/{id}";
    }


}
