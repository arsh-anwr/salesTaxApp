package com.salesTaxApp.exemptedHandler;

import java.util.List;

public class KeywordExemptionRule implements ExemptionRule {
    private final List<String> keywords;

    public KeywordExemptionRule(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean isExempt(String itemName) {
        String lower = itemName.toLowerCase();
        return keywords.stream().anyMatch(lower::contains);
    }
}
