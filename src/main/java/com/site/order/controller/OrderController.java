package com.site.order.controller;

import com.site.order.model.Order;
import com.site.order.model.OrderResponseDTO;
import com.site.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(
            @PathVariable String customerId) {

        return orderService.getOrdersByCustomerId(customerId);
    }

    @GetMapping("/{orderId}/customer")
    public OrderResponseDTO getOrderWithCustomer(
            @PathVariable Long orderId) {

        return orderService.getOrderWithCustomer(orderId);
    }
}