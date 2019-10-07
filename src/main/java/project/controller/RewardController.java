package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import project.persistence.entities.Deal;
import project.persistence.entities.User;
import project.service.DealService;
import project.service.UserService;

@Controller
public class RewardController {
    private DealService dealService;
    private UserService userService;

    @Autowired
    public RewardController(DealService dealService, UserService userService) {
     this.dealService = dealService;
     this.userService = userService;
    }

    public String viewPoints(User user, Model model){
        return "view points";
    }

    public String spendPoints(User user, Deal deal, Model model){
        return "spend points";
    }
    public String viewDeals(User user, Model model){
        return "view deals";
    }

}
