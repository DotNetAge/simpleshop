package com.example.simpleshop.controllers;

import com.example.simpleshop.exceptions.OrderNotFoundException;
import com.example.simpleshop.models.Order;
import com.example.simpleshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/orders")
@RestController
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 确认支付订单
     *
     * @param id
     * @return
     */
    @PostMapping("/confirm/{id}")
    public ResponseEntity<Order> confirm(@PathVariable long id) {
        throw new OrderNotFoundException();
    }

    /**
     * 获取订单详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Order> detail(@PathVariable long id) {
        Optional<Order> order = orderService.getOrder(id);
        return order.isPresent() ? new ResponseEntity<Order>(order.get(), HttpStatus.OK) :
                new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
    }

    /***
     * 我的订单列表
     * */
    public ResponseEntity<List<Order>> getOrders(PageRequest pageRequest) {
        throw new OrderNotFoundException();
    }

    /***
     * 订单管理列表
     * */
    public ResponseEntity<List<Order>> all(PageRequest pageRequest) {
        throw new OrderNotFoundException();
    }


}
