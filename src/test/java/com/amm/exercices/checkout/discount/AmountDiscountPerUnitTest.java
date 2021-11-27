package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.product.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.amm.exercices.checkout.product.ItemFactory.tshirtWithNameAndUnitPrice;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountDiscountPerUnitTest {

    @Test
    void givenNumberOfItemsGreaterThanThresholdShouldApplyDiscountedPriceMultiplyingNumberOfItems() {
        AmountDiscountPerUnit discount = new AmountDiscountPerUnit(4, new BigDecimal(19.0));

        BigDecimal result = discount.apply(givenSmallList());

        assertThat(result.compareTo(new BigDecimal(60.0))).isEqualTo(0);
    }

    @Test
    void givenNumberOfItemsLessThanThresholdShouldApplyBasePriceMultiplyingNumberOfItems() {
        AmountDiscountPerUnit discount = new AmountDiscountPerUnit(4, new BigDecimal(19.0));

        BigDecimal result = discount.apply(givenBigList());

        assertThat(result.compareTo(new BigDecimal(95.0))).isEqualTo(0);
    }

    private List<Item> givenSmallList() {
        return asList(tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)), tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)),
                tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)));
    }

    private List<Item> givenBigList() {
        return asList(tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)), tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)),
                tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)), tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)),
                tshirtWithNameAndUnitPrice("TSHIRT1", new BigDecimal(20.00)));
    }
}
