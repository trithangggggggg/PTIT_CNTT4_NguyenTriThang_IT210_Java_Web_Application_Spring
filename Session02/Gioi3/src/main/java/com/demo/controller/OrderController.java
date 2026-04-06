package com.demo.controller;

import com.demo.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session,
                             HttpServletRequest request,
                             Model model) {

        Object loggedUser = session.getAttribute("loggedUser");
        if (loggedUser == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        cal.set(2026, Calendar.APRIL, 1);
        orders.add(new Order("ORD001", "Bàn phím cơ", 1250000, cal.getTime()));

        cal.set(2026, Calendar.APRIL, 2);
        orders.add(new Order("ORD002", "Chuột gaming", 850000, cal.getTime()));

        cal.set(2026, Calendar.APRIL, 3);
        orders.add(new Order("ORD003", "Tai nghe bluetooth", 1590000, cal.getTime()));

        cal.set(2026, Calendar.APRIL, 4);
        orders.add(new Order("ORD004", "Màn hình 24 inch", 3290000, cal.getTime()));

        model.addAttribute("orders", orders);

        ServletContext application = request.getServletContext();

        AtomicInteger counter;
        synchronized (application) {
            counter = (AtomicInteger) application.getAttribute("totalViewCount");
            if (counter == null) {
                counter = new AtomicInteger(0);
                application.setAttribute("totalViewCount", counter);
            }
        }
        counter.incrementAndGet();

        return "orders";
    }
}