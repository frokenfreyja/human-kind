package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.User;
import project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.io.File;
import java.io.IOException;

@Controller
public class AccountController {

    // Instance Variables
    private UserService userService;

    // Dependency Injection
    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGet(Model model) {

        model.addAttribute("user", new User());

        return "SignUp";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute("user") User user, Model model, HttpServletRequest httpServletRequest){
        MultipartFile imagefile = user.getImage();
        String fileName;

        try {
            imagefile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(user.getImage()==null) throw new NullPointerException("unable to get" + imagefile);


        String rootDir = httpServletRequest.getSession().getServletContext().getRealPath("/");

        System.out.println("yep " + rootDir);
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
        
        //Debug
        System.out.println(user);
        userService.save(user);


        return "redirect:/user";
    }

    //@RequestMapping
    public String deleteAccount(User user, Model model) {
        return "";
    }
}
