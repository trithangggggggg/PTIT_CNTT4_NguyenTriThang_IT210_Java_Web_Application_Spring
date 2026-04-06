package com.demo.model;

import java.util.Date;

public class Order {
    private String orderCode;
    private String productName;
    private double totalAmount;
    private Date orderDate;

    public Order(String orderCode, String productName, double totalAmount, Date orderDate) {
        this.orderCode = orderCode;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}