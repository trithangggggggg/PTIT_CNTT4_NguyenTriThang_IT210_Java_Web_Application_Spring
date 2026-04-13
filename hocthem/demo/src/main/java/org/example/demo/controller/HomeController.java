package org.example.demo.controller;


import org.example.demo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    List<Person> users = new ArrayList<>(
            List.of(
                    new Person(false, 20, "Tri thang", 1, "https://i.pinimg.com/1200x/3e/40/52/3e40526eccb5b0721b66b16addbfa4f9.jpg"),
                    new Person(true, 19, "Viet Nam", 2, "https://i.pinimg.com/1200x/6a/4c/80/6a4c80dc8f8c4e1e404d14f28d3a508f.jpg"),
                    new Person(false, 20, "Thay Binh", 3, "https://i.pinimg.com/736x/79/13/4d/79134d63895695c693e2a6d882419ac7.jpg"),
                    new Person(true, 36, "Phuong", 4, "https://i.pinimg.com/736x/79/13/4d/79134d63895695c693e2a6d882419ac7.jpg")

            )
    );

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("users", users);
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        users.removeIf(user -> user.getId() == id);
        return "redirect:/";

    }
}
