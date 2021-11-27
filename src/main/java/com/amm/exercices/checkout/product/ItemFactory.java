package com.amm.exercices.checkout.product;

import com.amm.exercices.checkout.checkout.ItemType;

import java.math.BigDecimal;

import static com.amm.exercices.checkout.product.Item.itemWithCodeNameAndPrice;

public class ItemFactory {
    private ItemFactory() {
        throw new UnsupportedOperationException("Instantion not allowed");
    }

    public static Item voucherWithNameAndUnitPrice(String name, BigDecimal price) {
        return itemWithCodeNameAndPrice(ItemType.VOUCHER, name, price);
    }

    public static Item tshirtWithNameAndUnitPrice(String name, BigDecimal price) {
        return itemWithCodeNameAndPrice(ItemType.TSHIRT, name, price);
    }

    public static Item pantsWithNameAndUnitPrice(String name, BigDecimal price) {
        return itemWithCodeNameAndPrice(ItemType.PANTS, name, price);
    }
}
