package io.security.securityreview.controller.user;

import io.security.securityreview.domain.AccountDto;
import io.security.securityreview.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/users/register")
    public String registerPage(){
        return "/user/login/register";
    }
    @PostMapping("/users/register")
    public String createUser(AccountDto accountDto){
        userService.createUser(accountDto);
        return "redirect:/";
    }
}
