package com.example.simpleshop.repositories;

import com.example.simpleshop.models.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
