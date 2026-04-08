package org.example.kha1.controller;


import org.example.kha1.model.Student;
import org.example.kha1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// danh dau bean no la controller
@Controller

// danh dau day la duong dan den controller
// giong nhu nguoi giup viec lam duoc nheu dieu
@RequestMapping // mac dinh la dau /

/**
 * cac anotation pho biến
 * @component danh dau la bbean de khoi tao va ko co ngu nghia
 * @Controller: danh dau la bean va muc dich la dieu huong (le tan)
 * @Service: danh dau la bean va muc dich la xu ly logic (nguoi giup viec)
 * @Repository : danh dau la bean va muc dich la truy xuat du lieu xy ly tuong tac database (DAO)
 * @Autowired : Dung de tiem su phu thuoc (DI - Dependency Injection) tu dong khoi tao va gan gia tri cho cac bean
 * **/



public class HomeController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)

    // Dai dien cho 1 tinh nang cua nguoi giup viec, vi du : rua bat
    public String home() {
        List<Student> students = studentService.getAllStudents();
        System.out.println(students);
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name", defaultValue = "") String keyword){
        System.out.println("Noi dung: "+keyword);
        return "home";
    }
}
