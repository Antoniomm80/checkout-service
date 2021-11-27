package com.amm.exercices.checkout.checkout;

import com.amm.exercices.checkout.discount.PriceRules;
import com.amm.exercices.checkout.product.Item;
import com.amm.exercices.checkout.store.Store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckoutWithProductCategoryDiscounts implements CheckoutService {
    private BigDecimal total;
    private PriceRules priceRules;
    private List<Item> cart;

    public CheckoutWithProductCategoryDiscounts(PriceRules priceRules) {
        this.total = new BigDecimal(0);
        this.priceRules = priceRules;
        this.cart = new ArrayList<>();
    }

    @Override
    public void scan(String itemName) {
        Optional<Item> scannedItem = Store.getInstance()
                                          .getItemFromStore(itemName);
        //TODO: que pasa si no se encuentra?
        scannedItem.ifPresent(cart::add);
        this.total = recalculateCartPrice();
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }

    private BigDecimal recalculateCartPrice() {
        return ItemType.getAvailableItemTypes()
                       .stream()
                       .map(type -> priceRules.calculatePriceForItemsOfType(cart, type))
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
