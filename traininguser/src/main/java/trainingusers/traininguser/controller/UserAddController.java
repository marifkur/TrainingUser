package trainingusers.traininguser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import trainingusers.traininguser.dao.*;
import trainingusers.traininguser.entity.User;

import javax.validation.Valid;

@Controller
public class UserAddController {

    @Autowired
    private PermissionDao pd;

    @Autowired
    private RoleDao rd;

    @Autowired
    private RolePermissionDao rpd;

    @Autowired
    private UserDao ud;

    @Autowired
    private UserRoleDao urd;

    @RequestMapping("/addUser")
    public ModelAndView displayUser(){
        ModelAndView modelAndView = new ModelAndView("user/addUserPage");

        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/addUser", params = {"save"}, method = RequestMethod.POST)
    public String saveProfile(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "user/addUserPage";
        }

        if (ud.findOne(user.getUsername())==null){
            ud.save(user);
        }
        return "redirect:/user/userPage";
    }
}
