package com.example.simpleshop.repositories;

import com.example.simpleshop.models.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Long> {
}
