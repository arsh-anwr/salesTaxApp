package com.salesTaxApp.taxCalculator;


import com.salesTaxApp.models.Item;

public class BasicTaxRule implements TaxRule {
    private static final double RATE = 0.10;

    @Override
    public boolean appliesTo(Item item) {
        return !item.isExempted();
    }

    @Override
    public double computeTax(Item item) {
        return item.getPrice() * RATE;
    }
}
