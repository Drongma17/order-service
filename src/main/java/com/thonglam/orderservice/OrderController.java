package com.thonglam.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping
    public List<Order> fetchOrders() {
        return orderDao.getOrders().stream().
                sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
    }
}
