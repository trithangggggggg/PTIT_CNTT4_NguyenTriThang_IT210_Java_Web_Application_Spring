package com.demo.controller;

import com.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    @GetMapping("/report")
    public String showReport(Model model) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("Nguyen Tri Thang ", 95));
        list.add(new Student("Vu Viet Tien ", 82));
        list.add(new Student("Nguyen Tuan Minh ", 67));
        list.add(new Student("<script>alert('hack')</script>", 50));

        model.addAttribute("studentList", list);
        model.addAttribute("reportTitle", "Báo cáo điểm sinh viên");

        return "report";
    }
}