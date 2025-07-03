package com.salesTaxApp.exemptedHandler;

public interface ExemptionRule {
    boolean isExempt(String itemName);
}