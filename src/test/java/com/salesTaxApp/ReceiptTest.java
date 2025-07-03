package src.test.java.com.salesTaxApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.com.salesTaxApp.exemptedHandler.ExemptionClassifier;
import src.main.java.com.salesTaxApp.exemptedHandler.KeywordExemptionRule;
import src.main.java.com.salesTaxApp.inputParser.ItemParser;
import src.main.java.com.salesTaxApp.models.Item;
import src.main.java.com.salesTaxApp.receipt.Receipt;
import src.main.java.com.salesTaxApp.taxCalculator.TaxCalculator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReceiptTest {

    private ExemptionClassifier classifier;
    private ItemParser itemParser;
    private TaxCalculator taxCalculator;
    private Receipt receipt;

    @BeforeEach
    void setUp() {
        classifier = new ExemptionClassifier();
        classifier.registerRule(new KeywordExemptionRule(List.of("book", "chocolate", "pill")));
        itemParser = new ItemParser(classifier);
        taxCalculator = new TaxCalculator();
        receipt = new Receipt();
    }

    private void buildReceiptFromInput(String input) {
        List<Item> items = itemParser.parseAll(input);
        for (Item item : items) {
            double tax = taxCalculator.calculateTax(item);
            receipt.addItem(item, tax);
        }
    }

    @Test
    public void testInput1() {
        String input = """
            1 book at 12.49
            1 music CD at 14.99
            1 chocolate bar at 0.85
        """;

        buildReceiptFromInput(input);

        assertEquals(1.50, receipt.getTotalTax(), 0.01);
        assertEquals(29.83, receipt.getTotalAmount(), 0.01);
    }

    @Test
    public void testInput2() {
        String input = """
            1 imported box of chocolates at 10.00
            1 imported bottle of perfume at 47.50
        """;

        buildReceiptFromInput(input);

        assertEquals(7.65, receipt.getTotalTax(), 0.01);
        assertEquals(65.15, receipt.getTotalAmount(), 0.01);
    }

    @Test
    public void testInput3() {
        String input = """
            1 imported bottle of perfume at 27.99
            1 bottle of perfume at 18.99
            1 packet of headache pills at 9.75
            1 box of imported chocolates at 11.25
        """;

        buildReceiptFromInput(input);

        assertEquals(6.70, receipt.getTotalTax(), 0.01);
        assertEquals(74.68, receipt.getTotalAmount(), 0.01);
    }
}