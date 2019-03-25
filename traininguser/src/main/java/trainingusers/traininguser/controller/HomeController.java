package trainingusers.traininguser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {



    @RequestMapping("/home")
    public String home(){

        return "home";
    }

    @RequestMapping(value = "/home", params = {"user"}, method = RequestMethod.POST)
    public String goToUserPage() {

        return "user/userPage";
    }

    @RequestMapping(value = "/home", params = {"role"}, method = RequestMethod.POST)
    public String goToRolePage() {

        return "role/rolePage";
    }

    @RequestMapping(value = "/home", params = {"permission"}, method = RequestMethod.POST)
    public String goToPermissionPage() {

        return "permission/permissionPage";
    }
}
