package com.salesTaxApp.receipt;

import com.salesTaxApp.models.Item;
import com.salesTaxApp.models.ReceiptItem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<ReceiptItem> lineItems;

    public Receipt() {
        lineItems = new ArrayList<>();
    }

    public void addItem(Item item, double tax) {
        double totalPrice = item.getPrice() + tax;
        lineItems.add(ReceiptItem.builder()
                        .item(item)
                        .taxAmount(tax)
                        .totalPriceWithTax(totalPrice)
                        .build());
    }

    public void printReceipt() {
        DecimalFormat df = new DecimalFormat("0.00");
        double totalTax = 0.0;
        double totalAmount = 0.0;

        for (ReceiptItem line : lineItems) {
            Item item = line.getItem();
            System.out.printf("%d %s: %s%n", item.getQuantity(), item.getName(), df.format(line.getTotalPriceWithTax()));
            totalTax += line.getTaxAmount();
            totalAmount += line.getTotalPriceWithTax();
        }

        System.out.printf("Sales Taxes: %s%n", df.format(totalTax));
        System.out.printf("Total: %s%n", df.format(totalAmount));
    }

    public double getTotalTax() {
        return lineItems.stream().mapToDouble(ReceiptItem::getTaxAmount).sum();
    }

    public double getTotalAmount() {
        return lineItems.stream().mapToDouble(ReceiptItem::getTotalPriceWithTax).sum();
    }
}
