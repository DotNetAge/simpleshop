package com.example.simpleshop.repositories;

import com.example.simpleshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
