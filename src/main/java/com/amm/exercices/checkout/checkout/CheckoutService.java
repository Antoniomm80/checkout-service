package com.amm.exercices.checkout.checkout;

import java.math.BigDecimal;

public interface CheckoutService {

    void scan(String itemName);

    BigDecimal getTotal();
}
