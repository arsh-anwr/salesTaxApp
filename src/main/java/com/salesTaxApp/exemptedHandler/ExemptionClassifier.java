package com.salesTaxApp.exemptedHandler;

import java.util.ArrayList;
import java.util.List;

public class ExemptionClassifier {
    private final List<ExemptionRule> rules;

    public ExemptionClassifier() {
        rules = new ArrayList<>();
    }

    public void registerRule(ExemptionRule rule) {
        rules.add(rule);
    }

    public boolean isExempt(String itemName) {
        return rules.stream().anyMatch(rule -> rule.isExempt(itemName));
    }
}
