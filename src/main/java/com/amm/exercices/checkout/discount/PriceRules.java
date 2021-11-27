package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.checkout.ItemType;
import com.amm.exercices.checkout.product.Item;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class PriceRules {
    private EnumMap<ItemType, Discount> discountsToApply;
    private Discount defaultDiscount;

    public PriceRules(EnumMap<ItemType, Discount> discountsToApply) {
        this.discountsToApply = discountsToApply;
        defaultDiscount = new IdentityDiscount();
    }

    public BigDecimal calculatePriceForItemsOfType(List<Item> items, ItemType itemType) {
        Discount discountForCategory = discountsToApply.getOrDefault(itemType, defaultDiscount);
        List<Item> itemsForCategory = items.stream()
                                           .filter(i -> i.getCode()
                                                         .equals(itemType))
                                           .collect(Collectors.toList());

        return discountForCategory.apply(itemsForCategory);
    }
}
