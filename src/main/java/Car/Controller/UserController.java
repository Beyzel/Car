package Car.Controller;

import Car.entity.User;
import Car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String users(Model model) throws Exception {
        model.addAttribute("user", userService.getAllUsers());
        return "user";
    }

    @RequestMapping(value = "/user/{id}")
    public String detail(Model model, @PathVariable(value = "id") int id) throws Exception {
        model.addAttribute("user", userService.findOne(id));
        return "user-detail";
    }

    @RequestMapping(value = "/register")
    public String showRegister() throws Exception {
        return "user-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) throws Exception {
        userService.saveUser(user);
        return "user-register";
    }

    @ModelAttribute(value = "user")
    public User construct() {
        return new User();
    }

}