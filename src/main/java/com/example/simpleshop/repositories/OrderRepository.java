package com.example.simpleshop.repositories;

import com.example.simpleshop.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
