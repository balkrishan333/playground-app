package com.nagpal.bala.playgroundapp.yaml;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderLine {
    private String item;
    private int quantity;
    private BigDecimal unitPrice;

    // Constructors, Getters, Setters and toString
}
