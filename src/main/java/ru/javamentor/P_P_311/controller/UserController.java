package ru.javamentor.P_P_311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.P_P_311.model.User;
import ru.javamentor.P_P_311.service.UserService;


@Controller
public class UserController {
    private final UserService userService;
        @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public String findUser(Model model) {
        model.addAttribute("list", userService.findAll());
        return "user";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
            model.addAttribute("user", new User());
            return "info";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") long id, Model model) {
            model.addAttribute("user", userService.findById(id));
            return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        System.out.println("Updating user with id: " + user.getId());
            userService.update(user);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") long id) {
            userService.delete(id);
        return "redirect:/user";
    }
}
