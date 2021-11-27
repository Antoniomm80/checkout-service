package com.amm.exercices.checkout.store;

import com.amm.exercices.checkout.product.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.amm.exercices.checkout.product.ItemFactory.*;

public class StoreMother {
    public static void initDummyStoreWithNumberOfItems(int numItemsPerType) {
        List<Item> defaultProducts = new ArrayList<>();
        for (int i = 0; i < numItemsPerType; i++) {
            defaultProducts.add(tshirtWithNameAndUnitPrice("Summer T-Shirt", new BigDecimal(20.00)));
        }
        for (int i = 0; i < numItemsPerType; i++) {
            defaultProducts.add(pantsWithNameAndUnitPrice("Summer pants", new BigDecimal(7.50)));
        }
        for (int i = 0; i < numItemsPerType; i++) {
            defaultProducts.add(voucherWithNameAndUnitPrice("Gift Card", new BigDecimal(5.00)));
        }
        Store.getInstance()
             .initStore(defaultProducts);
    }
}
