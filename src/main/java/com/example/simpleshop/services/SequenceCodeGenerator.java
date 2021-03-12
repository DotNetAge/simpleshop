package com.example.simpleshop.services;

import org.springframework.stereotype.Component;

@Component
public class SequenceCodeGenerator implements OrderCodeGenerator {
    private String prefix = "O";

    @Override
    public String next() {
        return "";
    }
}
