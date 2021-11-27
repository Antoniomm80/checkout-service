package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.checkout.ItemType;

import java.math.BigDecimal;
import java.util.EnumMap;

public class PriceRulesFactory {
    private PriceRulesFactory() {
        throw new UnsupportedOperationException("Instantion not allowed");
    }

    public static PriceRules defaultPriceRules() {
        EnumMap<ItemType, Discount> discounts = new EnumMap<>(ItemType.class);
        discounts.put(ItemType.VOUCHER, new Nx1Discount(2));
        discounts.put(ItemType.TSHIRT, new AmountDiscountPerUnit(3, new BigDecimal(19.0)));
        discounts.put(ItemType.PANTS, new IdentityDiscount());

        return new PriceRules(discounts);
    }
}
