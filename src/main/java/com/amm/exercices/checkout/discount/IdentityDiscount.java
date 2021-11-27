package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.product.Item;

import java.math.BigDecimal;
import java.util.List;

public class IdentityDiscount implements Discount {
    @Override
    public BigDecimal apply(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return items.stream()
                    .map(Item::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
