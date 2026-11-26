package com.site.order.service;

import com.site.order.model.*;
import com.site.order.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestClient restClient;

    public OrderService(
            OrderRepository orderRepository,
            RestClient restClient) {

        this.orderRepository = orderRepository;
        this.restClient = restClient;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public OrderResponseDTO getOrderWithCustomer(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        CustomerDTO customer = restClient.get()
                .uri("/api/customers/{id}", order.getCustomerId())
                .retrieve()
                .body(CustomerDTO.class);

        return new OrderResponseDTO(
                order.getId(),
                order.getAmount(),
                order.getProduct(),
                customer
        );
    }
}