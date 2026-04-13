package org.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping
    public String showForm() {
        return "form-upload";
    }

    @PostMapping
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Bạn chưa chọn file");
            return "result";
        }

        String fileName = file.getOriginalFilename();

        String path = "C:\\Users\\ROG\\Desktop\\RIKKEI\\Java_Web_Application\\Session07\\demo\\src\\main\\webapp\\images\\";

        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File convertFile = new File(folder, fileName);

        try {
            file.transferTo(convertFile);
        } catch (IOException e) {
            model.addAttribute("error", "Upload thất bại");
            return "result";
        }

        model.addAttribute("fileName", fileName);
        return "result";
    }
}