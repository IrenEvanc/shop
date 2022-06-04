package company.controller;

import company.entity.User.AuthUser;
import company.entity.User.User;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/homepage")
public class AccountController {

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public User get (@AuthenticationPrincipal AuthUser authUser) {
        return authUser.getUser();
    }

}
