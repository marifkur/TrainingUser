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
public class LoginController {


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

    @RequestMapping("/")
    public ModelAndView goToLogin(UserRole userRole){
        ModelAndView modelAndView = new ModelAndView("login/loginPage");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView displayLogin(UserRole userRole){
        ModelAndView modelAndView = new ModelAndView("login/loginPage");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/login", params = {"login"}, method = RequestMethod.POST)
    public String loginUser( User user){

        User u = ud.findOne(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return "redirect:/user/userPage";
            }
        }
        return "login/loginPage";

    }

    @RequestMapping(value = "/login", params = {"regis"}, method = RequestMethod.POST)
    public ModelAndView goToRegister(){
        ModelAndView modelAndView= new ModelAndView("register/registerPage");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

}
