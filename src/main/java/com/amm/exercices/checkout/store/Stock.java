package com.amm.exercices.checkout.store;

import com.amm.exercices.checkout.product.Item;

import java.util.Optional;

public interface Stock {
    void addItemToStock(Item item);

    Optional<Item> getAnItemFromStock(String name);
}
