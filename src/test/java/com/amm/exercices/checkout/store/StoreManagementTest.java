package com.amm.exercices.checkout.store;

import com.amm.exercices.checkout.checkout.CheckoutWithProductCategoryDiscounts;
import com.amm.exercices.checkout.discount.PriceRulesFactory;
import com.amm.exercices.checkout.product.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static com.amm.exercices.checkout.store.StoreMother.initDummyStoreWithNumberOfItems;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreManagementTest {

    @BeforeEach
    void setup() {
        initDummyStoreWithNumberOfItems(15);
    }

    @Test
    void givenScannedItemsShouldUpdateAvailableStock() {
        CheckoutWithProductCategoryDiscounts checkout = new CheckoutWithProductCategoryDiscounts(PriceRulesFactory.defaultPriceRules());
        Store store = Store.getInstance();
        InMemoryStock stock = (InMemoryStock) ReflectionTestUtils.getField(store, "stock");
        List<Item> items = (List<Item>) ReflectionTestUtils.getField(stock, "availableStock");
        int originalStockSize = items.size();

        checkout.scan("Gift Card");
        checkout.scan("Summer T-Shirt");
        checkout.scan("Summer pants");

        assertThat(items.size()).isEqualTo(originalStockSize - 3);
    }
}
