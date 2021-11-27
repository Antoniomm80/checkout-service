package com.amm.exercices.checkout.checkout;

import com.amm.exercices.checkout.discount.PriceRulesFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.amm.exercices.checkout.store.StoreMother.initDummyStoreWithNumberOfItems;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutProcessTest {

    private CheckoutWithProductCategoryDiscounts checkout;

    @BeforeEach
    void setup() {
        initDummyStoreWithNumberOfItems(15);
        checkout = new CheckoutWithProductCategoryDiscounts(PriceRulesFactory.defaultPriceRules());
    }

    @Test
    void givenScenarioTest1ShouldReturnCorrectCalculation() {

        checkout.scan("Gift Card");
        checkout.scan("Summer T-Shirt");
        checkout.scan("Summer pants");

        assertThat(checkout.getTotal()
                           .compareTo(new BigDecimal(32.50))).isEqualTo(0);
    }

    @Test
    void givenScenarioTest2ShouldReturnCorrectCalculation() {

        checkout.scan("Gift Card");
        checkout.scan("Summer T-Shirt");
        checkout.scan("Gift Card");

        assertThat(checkout.getTotal()
                           .compareTo(new BigDecimal(25.00))).isEqualTo(0);
    }

    @Test
    void givenScenarioTest3ShouldReturnCorrectCalculation() {
        CheckoutWithProductCategoryDiscounts checkout = new CheckoutWithProductCategoryDiscounts(PriceRulesFactory.defaultPriceRules());

        checkout.scan("Summer T-Shirt");
        checkout.scan("Summer T-Shirt");
        checkout.scan("Summer T-Shirt");
        checkout.scan("Gift Card");
        checkout.scan("Summer T-Shirt");

        assertThat(checkout.getTotal()
                           .compareTo(new BigDecimal(81.00))).isEqualTo(0);
    }

    @Test
    void givenScenarioTest4ShouldReturnCorrectCalculation() {
        CheckoutWithProductCategoryDiscounts checkout = new CheckoutWithProductCategoryDiscounts(PriceRulesFactory.defaultPriceRules());

        checkout.scan("Gift Card");
        checkout.scan("Summer T-Shirt");
        checkout.scan("Gift Card");
        checkout.scan("Gift Card");
        checkout.scan("Summer pants");
        checkout.scan("Summer T-Shirt");
        checkout.scan("Summer T-Shirt");

        assertThat(checkout.getTotal()
                           .compareTo(new BigDecimal(74.50))).isEqualTo(0);
    }

    @Test
    void givenSameCartInDifferentOrderShouldReturnSamePrice() {
        CheckoutWithProductCategoryDiscounts checkout1 = new CheckoutWithProductCategoryDiscounts(PriceRulesFactory.defaultPriceRules());

        checkout1.scan("Gift Card");
        checkout1.scan("Summer T-Shirt");
        checkout1.scan("Gift Card");
        checkout1.scan("Gift Card");
        checkout1.scan("Summer pants");
        checkout1.scan("Summer T-Shirt");
        checkout1.scan("Summer T-Shirt");

        CheckoutWithProductCategoryDiscounts checkout2 = new CheckoutWithProductCategoryDiscounts(PriceRulesFactory.defaultPriceRules());

        checkout2.scan("Summer pants");
        checkout2.scan("Summer T-Shirt");
        checkout2.scan("Gift Card");
        checkout2.scan("Summer T-Shirt");
        checkout2.scan("Gift Card");
        checkout2.scan("Summer T-Shirt");
        checkout2.scan("Gift Card");

        CheckoutWithProductCategoryDiscounts checkout3 = new CheckoutWithProductCategoryDiscounts(PriceRulesFactory.defaultPriceRules());

        checkout3.scan("Summer pants");
        checkout3.scan("Summer T-Shirt");
        checkout3.scan("Summer T-Shirt");
        checkout3.scan("Gift Card");
        checkout3.scan("Gift Card");
        checkout3.scan("Gift Card");
        checkout3.scan("Summer T-Shirt");

        assertThat(checkout1.getTotal()
                            .compareTo(checkout2.getTotal())).isEqualTo(0);
        assertThat(checkout1.getTotal()
                            .compareTo(checkout3.getTotal())).isEqualTo(0);
    }

}
