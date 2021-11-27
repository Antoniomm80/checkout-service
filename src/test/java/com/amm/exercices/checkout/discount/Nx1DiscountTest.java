package com.amm.exercices.checkout.discount;

import com.amm.exercices.checkout.product.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static com.amm.exercices.checkout.product.ItemFactory.voucherWithNameAndUnitPrice;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class Nx1DiscountTest {
    @ParameterizedTest
    @CsvSource({ "3,4.5" })
    void givenNumItemsExactMultipleOfN_shouldReturnUnitPriceMultiplied(int multiplier, String expected) {
        Nx1Discount discount = new Nx1Discount(multiplier);

        BigDecimal result = discount.apply(givenExactMultipleItemList());

        assertThat(result.compareTo(new BigDecimal(expected))).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({ "3,13.5", "2,13.5", "4,9.0" })
    void givenNumItemsNonMultipleOfN_shouldReturnUnitPriceMultipliedPlusModulus(int multiplier, String expected) {
        Nx1Discount discount = new Nx1Discount(multiplier);

        BigDecimal result = discount.apply(givenNotExactMultipleItemList());

        assertThat(result.compareTo(new BigDecimal(expected))).isEqualTo(0);
    }

    private List<Item> givenExactMultipleItemList() {
        return asList(voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)), voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)),
                voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)));
    }

    private List<Item> givenNotExactMultipleItemList() {
        return asList(voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)), voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)),
                voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)), voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)),
                voucherWithNameAndUnitPrice("Voucher 1", new BigDecimal(4.5)));
    }
}
