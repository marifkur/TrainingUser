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
import trainingusers.traininguser.entity.UserRole;

import javax.validation.Valid;

@Controller
public class RegisterController {

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

    @RequestMapping("/regisUser")
    public ModelAndView displayRegister(UserRole userRole){
        ModelAndView modelAndView = new ModelAndView("login/loginPage");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/regisUser", params = {"regis"}, method = RequestMethod.POST)
    public String regisUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register/registerPage";
        }

        if (ud.findOne(user.getUsername())==null){
            ud.save(user);
        }

        return "login/loginPage";
    }


}
