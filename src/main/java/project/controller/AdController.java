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
import project.persistence.entities.Work;
import project.persistence.entities.User;
import project.service.UserService;
import project.service.WorkService;

@Controller
public class AdController {

    // Instance Variables
    private WorkService workService;
    private UserService userService;

    // Dependency Injection
    @Autowired
    public AdController(WorkService workService, UserService userService) {
        this.workService = workService;
        this.userService = userService;
    }

    @RequestMapping(value = "/new_ad", method = RequestMethod.GET)
    public String newAdForm(Model model) {
        model.addAttribute("work", new Work());
        model.addAttribute("works", workService.findAllReverseOrder());

        return "NewAd1";
    }

    @RequestMapping(value = "/new_ad", method = RequestMethod.POST)
    public String newItem(@ModelAttribute("work") Work work, Model model, HttpServletRequest httpServletRequest, HttpSession httpSession) throws IOException {

        Long userID = (Long) httpSession.getAttribute("currentUser");

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

        String location = work.getLocation();
        work.setLocation(location);

        workService.save(work);
        model.addAttribute("works", workService.findAllReverseOrder());
        model.addAttribute("work", new Work());

        return "Home";
    }

    //@RequestMapping
    public String deleteAd(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String editAd(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String viewAd(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String register(Work work, User user, Model model) {
        return "";
    }

    //@RequestMapping
    public String deregister(Work work, User user, Model model) {
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
