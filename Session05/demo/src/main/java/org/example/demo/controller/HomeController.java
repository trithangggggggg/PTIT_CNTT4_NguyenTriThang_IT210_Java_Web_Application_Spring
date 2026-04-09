package org.example.demo.controller;


import org.example.demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1, "Iphone 14 Pro Max", 30000000, 10, true),
                    new Product(2, "Samsung Galaxy S23 Ultra", 25000000, 15, true),
                    new Product(3, "Xiaomi Mi 12 Pro", 20000000, 20, true),
                    new Product(4, "Oppo Find X5 Pro", 22000000, 5, true),
                    new Product(5, "Vivo X80 Pro", 21000000, 8, true)
            )
    );

    @GetMapping
    public String home(Model model){
        model.addAttribute("products", products);
        return "home";
    }

//    @PostMapping("/add")
//    public String addProduct(Product product) {
//        products.add(product);
//        return "redirect:/home";
//    }

    @GetMapping("/delete/{id}")
    public String handleDelete(@PathVariable("id") int id) {
        products.removeIf(p -> p.getId() == id);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
