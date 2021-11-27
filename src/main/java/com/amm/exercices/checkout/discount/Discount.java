package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.product.Item;

import java.math.BigDecimal;
import java.util.List;

public interface Discount {
    BigDecimal apply(List<Item> items);
}
