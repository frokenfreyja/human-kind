package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Work;
import project.service.WorkService;

@Controller
public class SortController {

    // Instance Variables
    private WorkService workService;

    // Dependency Injection
    @Autowired
    public SortController(WorkService workService) {
        this.workService = workService;
    }

    //@RequestMapping
    public String interestSort(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String locationSort(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String durationSort(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String dateSort(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String organizationSort(Work work, Model model) {
        return "";
    }

    //@RequestMapping
    public String search(Work work, Model model) {
        return "";
    }
}