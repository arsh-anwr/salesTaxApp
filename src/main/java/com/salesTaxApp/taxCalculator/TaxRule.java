package com.salesTaxApp.taxCalculator;

import com.salesTaxApp.models.Item;

public interface TaxRule {
    boolean appliesTo(Item item);
    double computeTax(Item item);
}
