package src.main.java.com.salesTaxApp.taxCalculator;

import src.main.java.com.salesTaxApp.models.Item;

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
