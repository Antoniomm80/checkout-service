package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.product.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AmountDiscountPerUnit implements Discount {

    private int amountThreshold;
    private BigDecimal discountedItemPrice;

    public AmountDiscountPerUnit(int amountThreshold, BigDecimal discountedItemPrice) {

        this.amountThreshold = amountThreshold;
        this.discountedItemPrice = discountedItemPrice;
    }

    @Override
    public BigDecimal apply(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }
        if (items.size() >= amountThreshold) {
            return new BigDecimal(discountedItemPrice.doubleValue() * items.size()).setScale(2, RoundingMode.HALF_UP);
        }
        return items.stream()
                    .map(Item::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
