package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.product.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Nx1Discount implements Discount {

    private int multiplier;

    public Nx1Discount(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public BigDecimal apply(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal unitPrice = items.get(0)
                                    .getPrice();
        int multiplyFactor = items.size() / multiplier;
        int modulus = items.size() % multiplier;
        return new BigDecimal((multiplyFactor * unitPrice.doubleValue()) + (modulus * unitPrice.doubleValue())).setScale(2, RoundingMode.HALF_UP);
    }
}
