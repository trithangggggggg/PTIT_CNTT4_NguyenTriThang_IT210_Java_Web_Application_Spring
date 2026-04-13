package org.example.bai3_ss07.controller;

import org.example.bai3_ss07.model.Food;
import org.example.bai3_ss07.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<String> categories = Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
        model.addAttribute("categories", categories);
        return "food-form";
    }

    @PostMapping("/add")
    public String addFood(@RequestParam("name") String name,
                          @RequestParam("category") String category,
                          @RequestParam("price") double price,
                          @RequestParam("image") MultipartFile file,
                          Model model) {

        List<String> categories = Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
        model.addAttribute("categories", categories);

        if (file.isEmpty()) {
            model.addAttribute("error", "Bạn chưa chọn ảnh.");
            return "food-form";
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            model.addAttribute("error", "Tên file không hợp lệ.");
            return "food-form";
        }

        String lowerFileName = fileName.toLowerCase();
        if (!(lowerFileName.endsWith(".jpg") || lowerFileName.endsWith(".jpeg") || lowerFileName.endsWith(".png"))) {
            model.addAttribute("error", "Chỉ chấp nhận file .jpg, .jpeg, .png");
            return "food-form";
        }

        if (price < 0) {
            model.addAttribute("error", "Giá tiền phải lớn hơn hoặc bằng 0.");
            return "food-form";
        }

        String uploadDir = "C:/RikkeiFood_Temp/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File destination = new File(uploadDir + fileName);

        try {
            file.transferTo(destination);
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi lưu file ảnh.");
            return "food-form";
        }

        Food food = new Food();
        food.setName(name);
        food.setCategory(category);
        food.setPrice(price);
        food.setImage(fileName);

        foodService.addFood(food);

        System.out.println("=== MÓN ĂN VỪA THÊM ===");
        System.out.println("Tên món: " + food.getName());
        System.out.println("Danh mục: " + food.getCategory());
        System.out.println("Giá: " + food.getPrice());
        System.out.println("Ảnh: " + food.getImage());
        System.out.println("Tổng số món hiện có: " + foodService.getTotalFoods());

        model.addAttribute("success", "Thêm món ăn thành công!");
        return "food-form";
    }
}