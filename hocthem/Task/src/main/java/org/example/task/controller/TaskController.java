package org.example.task.controller;

import org.example.task.model.Task;
import org.example.task.model.TaskStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class TaskController {

    List<Task> tasksList = new ArrayList<>(
            List.of(
                    new Task(1, "Học ôn tập thầy Bình", TaskStatus.SUCCESS),
                    new Task(2, "Đi ngủ", TaskStatus.PENDING),
                    new Task(3, "Thức dậy", TaskStatus.PENDING),
                    new Task(4, "Bê cỗ tiếp", TaskStatus.REJECTED)
            )
    );

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", tasksList);
        return "tasks";
    }
}
