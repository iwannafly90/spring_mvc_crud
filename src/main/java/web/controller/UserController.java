package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        return "users";
    }

    @PostMapping("/create/{id}")
    public String createNewUser(@ModelAttribute User user, Model model) {
        userService.addUser(user.getFirstName(), user.getLastName(), user.getEmail());
        return "redirect:/";
    }

    @GetMapping("/user_add")
    public String user_add(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        return "user_add";
    }

    @GetMapping("/{id}")
    public String selectUser(@PathVariable("id") int id, Model model ) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user_edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, @ModelAttribute User user, Model model) {
        userService.updateUser(id, user.getFirstName(), user.getLastName(), user.getEmail());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, @ModelAttribute User user, Model model) {
        userService.removeUser(id);
        return "redirect:/";
    }
}

