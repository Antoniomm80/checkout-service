package com.amm.exercices.checkout.product;

import com.amm.exercices.checkout.checkout.ItemType;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

public class Item {
    private ItemType code;
    private String name;
    private BigDecimal price;

    protected static Item itemWithCodeNameAndPrice(ItemType code, String name, BigDecimal price) {
        requireNonNull(code);
        requireNonNull(name);
        requireNonNull(price);
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("price must be positive");
        }
        return new Item(code, name, price);
    }

    private Item(ItemType code, String name, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public ItemType getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
