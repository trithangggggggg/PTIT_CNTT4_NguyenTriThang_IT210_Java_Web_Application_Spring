package org.example.test.controller;

import org.example.test.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String showEmployeeList(Model model) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Nguyen Tri Thang", "Dao tao", 36000));
        employees.add(new Employee(2, "Nguyen Tuan Minh", "CTSV", 10000));
        employees.add(new Employee(3, "Vu Viet Tien", "Security", 8000));
        employees.add(new Employee(4, "Pham Quoc Loc", "VS", 5000));

        model.addAttribute("employees", employees);

        return "employee-list";
    }
}