package src.main.java.com.salesTaxApp.taxCalculator;

import src.main.java.com.salesTaxApp.models.Item;

public interface TaxRule {
    boolean appliesTo(Item item);
    double computeTax(Item item);
}
