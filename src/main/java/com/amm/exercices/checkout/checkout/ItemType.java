package com.amm.exercices.checkout.checkout;

import java.util.Arrays;
import java.util.List;

public enum ItemType {
    VOUCHER, TSHIRT, PANTS, OTHER;

    public static List<ItemType> getAvailableItemTypes() {
        return Arrays.asList(ItemType.values());
    }
}
