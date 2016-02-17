package com.example.db;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Price { // Value Object
    private final BigDecimal value;

    public Price(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.HALF_UP);
    }

    public static Price of(String priceString) {
        return new Price(new BigDecimal(priceString));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                '}';
    }
}
