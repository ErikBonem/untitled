package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.sevice.UserService;
@Controller
@RequestMapping("/people")
public class UserController {
    private final UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", us.index());
        return "index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", us.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user")  User user){
        us.save(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", us.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
        us.update(user);
        return "redirect:/people";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        us.delete(id);
        return "redirect:/people";
    }
}
