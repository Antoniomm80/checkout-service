package com.amm.exercices.checkout.store;

import com.amm.exercices.checkout.product.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryStock implements Stock {
    private List<Item> availableStock;

    @Override
    public void addItemToStock(Item item) {
        if (availableStock == null) {
            availableStock = new ArrayList<>();
        }
        availableStock.add(item);
    }

    @Override
    public Optional<Item> getAnItemFromStock(String name) {
        Optional<Item> item = availableStock.stream()
                                            .filter(i -> i.getName()
                                                          .equals(name))
                                            .findFirst();
        item.ifPresent(availableStock::remove);
        return item;
    }
}
