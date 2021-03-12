package com.example.simpleshop.repositories;

import com.example.simpleshop.models.Category;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RestResource;

//@RestResource(path = "categories", rel = "catalog")
public interface CategoryRepository extends CrudRepository<Category, Long> {}
