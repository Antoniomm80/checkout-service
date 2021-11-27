package com.amm.exercices.checkout.store;

import com.amm.exercices.checkout.product.Item;

import java.util.List;
import java.util.Optional;

public class Store {
    private Stock stock;
    private static Store instance;

    private Store() {

    }

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public void initStore(List<Item> items) {
        stock = new InMemoryStock();
        for (Item item : items) {
            stock.addItemToStock(item);
        }
    }

    public Optional<Item> getItemFromStore(String name) {
        return stock.getAnItemFromStock(name);
    }
}
