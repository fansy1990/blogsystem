package blog.controllers;

import blog.forms.LoginForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;

import static blog.util.BlogUtils.*;
/**
 * Created by fanzhe on 2017/12/27.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notifyService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }
        if (!userService.authenticate(
                loginForm.getUsername(), loginForm.getPassword())) {
            notifyService.addErrorMessage("Invalid login!");
            return "users/login";
        }
        notifyService.addInfoMessage("Login successful");
        session.setAttribute(USERS,
                session.getAttribute(USERS) == null ?
                new HashSet<String>(){{
                    add(loginForm.getUsername());
                }}
                : ((HashSet)session.getAttribute(USERS)).add(loginForm.getUsername()));// 添加用户信息到session
        return "redirect:/";
    }

    @RequestMapping(value = "/users/register")
    public String register(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }
//        if (!userService.authenticate(
//                loginForm.getUsername(), loginForm.getPassword())) {
//            notifyService.addErrorMessage("Invalid login!");
//            return "users/login";
//        }
        notifyService.addInfoMessage("Register successful");
//        session.setAttribute(USERS,
//                session.getAttribute(USERS) == null ?
//                        new HashSet<String>(){{
//                            add(loginForm.getUsername());
//                        }}
//                        : ((HashSet)session.getAttribute(USERS)).add(loginForm.getUsername()));// 添加用户信息到session
        return "redirect:/users/login";
    }
}