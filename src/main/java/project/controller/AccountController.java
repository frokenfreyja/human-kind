package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.Ad;
import project.persistence.entities.*;
import project.persistence.repositories.ConfirmationTokenRepository;
import project.service.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    // Instance Variables
    private UserService userService;
    private AdService adService;
    private CourseService courseService;
    private ApplicantService applicantService;
    private CourseNameService courseNameService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailService;

    // Dependency Injection
    @Autowired
    public AccountController(UserService userService, AdService adService, ApplicantService applicantService, CourseService courseService, CourseNameService courseNameService) {

        this.userService = userService;
        this.adService = adService;
        this.courseService = courseService;
        this.applicantService = applicantService;
        this.courseNameService = courseNameService;
    }

    @RequestMapping(value ="/user/{id}", method = RequestMethod.GET)
    public String accountView(@PathVariable Long id, @ModelAttribute("user") User user, Model model, HttpSession session){

        Long userID = (Long)session.getAttribute("currentUser");
        User currUser = userService.findOne(userID);

        user = userService.findOne(id);
        model.addAttribute("user", user);

        // Get all of user's applications
        ArrayList<Ad> jobs = new ArrayList<>(applicantService.findAllApplications(user.getId()).size());
        ArrayList<Ad> completedJobs = new ArrayList<>(jobs.size());
        ArrayList<Applicant> applications = applicantService.findAllApplications(user.getId());
        for(int i=0; i<applications.size(); i++) {
            Long adID = applications.get(i).getAd();
            Ad ad = adService.findOne(adID);
            System.out.println(ad.getClosed());
            if(ad.getClosed())
                completedJobs.add(ad);
            System.out.println(completedJobs.toString());
            jobs.add(ad);
        }

        if(!user.getOrgi()) {
            model.addAttribute("jobs", jobs);
            model.addAttribute("compJobs", completedJobs);
            // get all user's courses
            ArrayList<CourseName> courseNames = courseNameService.findAllUsers(user.getId());
            ArrayList<Course> courses = new ArrayList<Course>(courseNames.size());
            for(int i=0; i<courseNames.size(); i++) {
                Long courseID = courseNames.get(i).getCourse();
                Course courseItem = courseService.findOne(courseID);
                courses.add(courseItem);
                System.out.println("test:");
                System.out.println(courseItem.toString());
            }

            model.addAttribute("courses", courses);
        }

        if(user.getOrgi()) {
            model.addAttribute("organization", true);
            model.addAttribute("own_ads", adService.findByOwner(user.getId()));
        }

        model.addAttribute("header_type", "red_bar");
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

            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("Humankindnotification@gmail.com");
            mailMessage.setText("To confirm your account, please click here: " +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            model.addAttribute("verification", "A verification email has been sent to: "+ user.getEmail());
            model.addAttribute("header_type", "red_bar");
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
            model.addAttribute("header_type", "red_bar");
        } else if(!(user.getPassword().equals(user.getConfirmPassword()))) {
            model.addAttribute("error", "Passwords don't match.");
            model.addAttribute("header_type", "red_bar");
        } else {
            user.setOrgi(false);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("Humankindnotification@gmail.com");
            mailMessage.setText("To confirm your account, please click here: " +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            model.addAttribute("verification", "A verification email has been sent to: "+ user.getEmail());
            model.addAttribute("header_type", "red_bar");
        }
        return "SignUpVol";
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(Model model, @RequestParam("token") String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        User user = userService.findByEmail(token.getUser().getEmail());

        if(token != null)
        {
            user.setEnabled(true);
            userService.save(user);
            model.addAttribute("message", "Congratulations! Your account has been activated and email is verified!");

            model.addAttribute("user", new User());
            model.addAttribute("header_type", "red_bar");
            return "Login";
        } else {
            model.addAttribute("message", "The link is invalid or broken!");

            if(user.getOrgi()) {
                return "SignUpOrg";
            } else {
                return "SignUpVol";
            }
        }
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
        List<Ad> ads = adService.findByOwner(currUser.getId());
        if(ads.size() != 0) {
            for (Ad ad : ads) {
                adService.delete(ad);

                // Delete all applicants of user's ads
                ArrayList<Applicant> applicants = applicantService.findAllApplicants(ad.getId());
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
    public String editAccount(@PathVariable Long id, @ModelAttribute("user") User user, @ModelAttribute("course") Course course, Model model, HttpSession session){

        Long userID = (Long)session.getAttribute("currentUser");
        User currUser = userService.findOne(userID);

        if(userID==null)
            return "Login";

        user = userService.findOne(id);
        model.addAttribute("user", user);

        model.addAttribute("course", course);

        // Get all of user's applications
        ArrayList<Ad> jobs = new ArrayList<>(applicantService.findAllApplications(user.getId()).size());
        ArrayList<Applicant> applications = applicantService.findAllApplications(user.getId());
        for(int i=0; i<applications.size(); i++) {
            Long adID = applications.get(i).getAd();
            Ad ad = adService.findOne(adID);
            jobs.add(ad);
        }

        if(!user.getOrgi()) {
            model.addAttribute("jobs", jobs);

            // get all user's courses
            ArrayList<CourseName> courseNames = courseNameService.findAllUsers(user.getId());
            ArrayList<Course> courses = new ArrayList<Course>(courseNames.size());
            for(int i=0; i<courseNames.size(); i++) {
                Long courseID = courseNames.get(i).getCourse();
                Course courseItem = courseService.findOne(courseID);
                courses.add(courseItem);
                System.out.println("test:");
                System.out.println(courseItem.toString());
            }

            model.addAttribute("courses", courses);
        }

        if(user.getOrgi()) {
            model.addAttribute("organization", true);
            model.addAttribute("own_ads", adService.findByOwner(user.getId()));
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
        ArrayList<Ad> jobs = new ArrayList<>(applicantService.findAllApplications(currUser.getId()).size());
        ArrayList<Applicant> applications = applicantService.findAllApplications(currUser.getId());
        for(int i=0; i<applications.size(); i++) {
            Long adID = applications.get(i).getAd();
            Ad ad = adService.findOne(adID);
            jobs.add(ad);
        }

        if(!currUser.getOrgi()) {
            model.addAttribute("jobs", jobs);
        }

        if(currUser.getOrgi()) {
            model.addAttribute("organization", true);
            model.addAttribute("own_ads", adService.findByOwner(user.getId()));
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

    @RequestMapping(value = "/add_course/{id}", method = RequestMethod.POST)
    public String addCoursePost(@PathVariable Long id, Course course, Model model, HttpSession httpSession) {
        Long userID = (Long) httpSession.getAttribute("currentUser");

        if(userID==null)
            return "Login";

        courseService.save(course);
        courseService.findByName(course.getCname());

        CourseName courseName = new CourseName();
        courseName.setCourse(course.getId());
        courseName.setUsers(userID);

        courseNameService.save(courseName);

        return "redirect:/edit_user/{id}";
    }
}
