package org.example.bai1_ss07.controller;

import org.example.bai1_ss07.model.RestaurantProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @GetMapping("/profile")
    public String showForm(Model model) {
        model.addAttribute("restaurantProfile", new RestaurantProfile());
        return "profile";
    }

    @PostMapping("/update-profile")
    public String update(@ModelAttribute RestaurantProfile profile, Model model) {
        model.addAttribute("restaurantProfile", profile);
        return "profile";
    }
}