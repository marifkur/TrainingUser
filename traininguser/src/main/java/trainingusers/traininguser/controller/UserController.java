package trainingusers.traininguser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import trainingusers.traininguser.dao.*;
import trainingusers.traininguser.entity.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

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

    @RequestMapping("/user/userPage")
    public ModelAndView viewUser() {
        ModelAndView modelAndView = new ModelAndView("user/userPage");
        modelAndView.addObject("userDetail", ud.findAll());

        return modelAndView;
    }

    @RequestMapping(value = "/datUser", params = {"add"}, method = RequestMethod.POST)
    public ModelAndView homeAddUser(){
        ModelAndView modelAndView= new ModelAndView("user/addUserPage");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/datUser", params = {"edit"})
    public ModelAndView editUser(User employee, HttpServletRequest req) {
        String no = String.valueOf(req.getParameter("edit"));

        ModelAndView modelAndView = new ModelAndView("user/editUserPage");
        modelAndView.addObject("user", ud.findOne(no));

        return modelAndView;

    }

    @RequestMapping(value = "/datUser", params = {"delete"})
    public String deleteUser(User employee, HttpServletRequest req) {
        String no = String.valueOf(req.getParameter("delete"));
        ud.delete(no);
        return "redirect:/user/userPage";
    }

}
