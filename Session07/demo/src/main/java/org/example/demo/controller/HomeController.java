package org.example.demo.controller;

import org.example.demo.model.Student;
import org.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    // co che dependenciy injection
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("student", new Student());
        return "form-add";
    }

    @PostMapping("/hande-add")
    public String handleAdd(@ModelAttribute("student") Student student) {
        studentRepository.addStudent(student);
        return "redirect:/";
    }

    @RequestMapping
    public String home(Model model) {
        model.addAttribute("students", studentRepository.getAllStudents());
        return "home";
    }
}