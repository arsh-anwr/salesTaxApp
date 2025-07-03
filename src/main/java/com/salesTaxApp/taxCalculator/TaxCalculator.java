package src.main.java.com.salesTaxApp.taxCalculator;

import src.main.java.com.salesTaxApp.models.Item;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    private final List<TaxRule> taxRules;

    public TaxCalculator() {
        taxRules = new ArrayList<>();
        taxRules.add(new BasicTaxRule());
        taxRules.add(new ImportDutyTaxRule());
    }

    public double calculateTax(Item item) {
        double tax = 0.0;
        for (TaxRule rule : taxRules) {
            if (rule.appliesTo(item)) {
                tax += rule.computeTax(item);
            }
        }
        return roundUpToNearest005(tax);
    }

    private double roundUpToNearest005(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}