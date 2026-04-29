package com.foodorder.service;

import com.foodorder.dto.OrderItemRequestDTO;
import com.foodorder.dto.OrderRequestDTO;
import com.foodorder.dto.OrderResponseDTO;
import com.foodorder.entity.Order;
import com.foodorder.entity.OrderItem;
import com.foodorder.repository.OrderItemRepository;
import com.foodorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order = orderRepository.save(order);

        List<OrderItem> items = new ArrayList<>();
        for(OrderItemRequestDTO itemDto : request.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setMenuItemId(itemDto.getMenuItemId());
            orderItem.setQuantity(itemDto.getQuantity());
            items.add(orderItemRepository.save(orderItem));
        }

        return new OrderResponseDTO(order, items);
    }

    public List<OrderResponseDTO> getUserOrders(Long userId) {
        List<Order> orders = orderRepository.findByUserIdOrderByCreatedAtDesc(userId);
        List<OrderResponseDTO> responses = new ArrayList<>();
        for(Order order : orders) {
            List<OrderItem> items = orderItemRepository.findByOrderId(order.getId());
            responses.add(new OrderResponseDTO(order, items));
        }
        return responses;
    }
}
