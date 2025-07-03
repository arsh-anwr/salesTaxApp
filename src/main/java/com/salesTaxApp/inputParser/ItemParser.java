package com.salesTaxApp.inputParser;

import com.salesTaxApp.exemptedHandler.ExemptionClassifier;
import com.salesTaxApp.exemptedHandler.KeywordExemptionRule;
import com.salesTaxApp.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.salesTaxApp.models.Patterns.ITEM_PATTERN;


public class ItemParser {
    private final ExemptionClassifier classifier;

    public ItemParser(ExemptionClassifier exemptionClassifier) {
        classifier = exemptionClassifier;
        classifier.registerRule(new KeywordExemptionRule(List.of("book", "chocolate", "pill")));
    }

    public List<Item> parseAll(String input) {
        List<Item> items = new ArrayList<>();
        Pattern itemPattern = Pattern.compile(ITEM_PATTERN);
        Matcher itemMatcher = itemPattern.matcher(input);

        while (itemMatcher.find()) {
            int quantity = Integer.parseInt(itemMatcher.group(1));
            String name = itemMatcher.group(2).trim();
            double price = Double.parseDouble(itemMatcher.group(3));

            boolean imported = name.contains("imported");
            boolean exempt = classifier.isExempt(name);

            items.add(
                    Item.builder()
                            .name(name)
                            .quantity(quantity)
                            .price(price)
                            .isImported(imported)
                            .isExempted(exempt)
                            .build()
            );
        }

        return items;
    }
}

