package trainingusers.traininguser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import trainingusers.traininguser.dao.*;
import trainingusers.traininguser.entity.User;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class UserEditController {

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

    @RequestMapping(value = "/editUser", params = {"cancel"}, method = RequestMethod.POST)
    public String backFromEdit() {

        return "redirect:/user/userPage";
    }

    @RequestMapping(value = "/editUser", params = {"edit"}, method = RequestMethod.POST)
    public String editUserPage(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "redirect:/user/editUserPage";
        }

        ud.save(user);
        return "redirect:/user/userPage";
    }


}
