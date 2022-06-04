package company.controller;

import company.entity.User.User;
import company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userlist")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList (Model model) {
        model.addAttribute("users", userService.allUsers());
        return "userlist";
    }
    @GetMapping({"user"})
    public String userEditForm (@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "userEdit";
    }

}
