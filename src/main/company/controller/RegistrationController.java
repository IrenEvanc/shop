package company.controller;

import company.entity.Basket;
import company.entity.Role;
import company.entity.User;
import company.repository.BasketRepository;
import company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    private BasketRepository basketRepository;


//    @GetMapping("/login")
//    public String get(Model model) {
//        model.addAttribute("title", "Форма входа");
//        return "login";
//    }

    @GetMapping("/registration")
    public String registration () {
        return "registration";
    }

    @PostMapping ("/registration")
    public String addUser(User user,  Model model) {
        User userFromDB = userRepository.findByLogin(user.getLogin());
        if (userFromDB != null) {
//            model.put("message", "User exists!");
            System.out.println("Пользователь уже существует");
            return  "/registration";
        }
        user.setActive(true);
        Basket basket = new Basket();

        user.setBasket(basket);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

//        basketRepository.save(basket);
        return "redirect:/login";
    }
}
