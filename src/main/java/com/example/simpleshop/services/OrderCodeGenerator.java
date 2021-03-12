package com.example.simpleshop.services;

public interface OrderCodeGenerator {
    /**
     * 生成单号
     * @return
     */
    String next();
}
