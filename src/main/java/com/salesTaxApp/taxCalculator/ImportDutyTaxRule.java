package com.salesTaxApp.taxCalculator;


import com.salesTaxApp.models.Item;

public class ImportDutyTaxRule implements TaxRule {
    private static final double RATE = 0.05;

    @Override
    public boolean appliesTo(Item item) {
        return item.isImported();
    }

    @Override
    public double computeTax(Item item) {
        return item.getPrice() * RATE;
    }
}
