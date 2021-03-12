package com.example.simpleshop.services;


import com.example.simpleshop.exceptions.OrderNotFoundException;
import com.example.simpleshop.models.CartItem;
import com.example.simpleshop.models.Order;
import com.example.simpleshop.repositories.CartItemRepository;
import com.example.simpleshop.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderService {
    private CartItemRepository cartItemRepo;
    private OrderRepository orderRepo;
    private OrderCodeGenerator generator;

    @Autowired
    public OrderService(CartItemRepository cartItemRepository,
                        OrderRepository orderRepo,
                        OrderCodeGenerator generator) {
        this.cartItemRepo = cartItemRepository;
        this.orderRepo = orderRepo;
        this.generator = generator;
    }

    public Optional<Order> getOrder(long id) {
        return this.orderRepo.findById(id);
    }

    /**
     * 从购物车生成订单
     *
     * @return Order
     */
    public Order checkOut(long customerId,
                          String customerName,
                          long handlerId,
                          String address,
                          List<CartItem> items) {

        //float totalAmount = items.stream().reduce(new CartItem(), (subTotal, element) -> subTotal.getAmount() + element.getAmount());
        float totalAmount = 0;
        Order order = new Order(generator.next(),
                handlerId,
                totalAmount,
                customerId,
                customerName,
                address);

        order.setItems(items.stream().map(CartItem::toOrderItem).collect(Collectors.toList()));
        orderRepo.save(order);
        //TODO: 发出新建订单事件 order.created 并写入事件存储

        throw new NotImplementedException();
    }

    /**
     * 取消指定编号的订单
     *
     * @return Order
     */
    public Boolean cancelById(Long orderId) throws OrderNotFoundException {
        Optional<Order> order = this.orderRepo.findById(orderId);
        if (order.isPresent()) {
            return this.cancel(order.get());
        }
        throw new OrderNotFoundException();
    }

    /**
     * 取消订单
     *
     * @return Order
     */
    public Boolean cancel(Order order) {
        order.setOrderStatus(Order.Status.CANCELED);
        //TODO: 将 order.cancelled 事件与入Kafka
        orderRepo.save(order);
        return true;
    }

    /**
     * 支付订单
     *
     * @return Order
     */
    public void pay(Long orderNumber, String confirmationNumber) {
        throw new NotImplementedException();
    }

    /**
     * 发货
     */
    public void dispatch() {
        throw new NotImplementedException();
    }

    /**
     * 订单支付成功
     *
     * @param orderId
     * @param confirmationNumber
     */
    public void payById(Long orderId, String confirmationNumber) {
        throw new NotImplementedException();
    }

    /**
     * 退单
     * 成功退单后发出 "order.refunded" 事件
     */
    public void refund(String orderId) {
        throw new NotImplementedException();
    }
}
