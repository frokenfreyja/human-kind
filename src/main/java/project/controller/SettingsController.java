package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import project.persistence.entities.User;
import project.service.CourseService;
import project.service.UserService;

@Controller
public class SettingsController {
    private CourseService courseService;
    private UserService userService;

    @Autowired
    public SettingsController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    public String editBio(User user, Model model) {
        return "editbio page";
    }

    public String changePhoto(User user, Model model) {
        return "changePhoto page";
    }

    public String editCompletedCourses(User user, Model model) {
        return "edit completed Courses page";
    }
}
