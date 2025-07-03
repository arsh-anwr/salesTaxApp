package src.main.java.com.salesTaxApp.appHandler;

import src.main.java.com.salesTaxApp.exemptedHandler.ExemptionClassifier;
import src.main.java.com.salesTaxApp.exemptedHandler.KeywordExemptionRule;
import src.main.java.com.salesTaxApp.inputParser.InputParser;
import src.main.java.com.salesTaxApp.inputParser.ItemParser;
import src.main.java.com.salesTaxApp.models.Item;
import src.main.java.com.salesTaxApp.receipt.Receipt;
import src.main.java.com.salesTaxApp.taxCalculator.TaxCalculator;

import java.util.List;

public class SalesAppHandler {
    private static final ThreadLocal<SalesAppHandler> appInstance = ThreadLocal.withInitial(SalesAppHandler::new);
    private final ExemptionClassifier classifier;
    private final ItemParser itemParser;
    private final InputParser inputParser;
    private final TaxCalculator taxCalculator;
    private final Receipt receipt;

    public SalesAppHandler() {
        inputParser = new InputParser();
        classifier = new ExemptionClassifier();
        classifier.registerRule(new KeywordExemptionRule(List.of("book", "chocolate", "pill")));
        itemParser = new ItemParser(classifier);
        taxCalculator = new TaxCalculator();
        receipt = new Receipt();
    }
    public void startApplication() {
        String items = inputParser.readItemLinesFromConsole();
        List<Item> itemList = itemParser.parseAll(items);

        for (Item item: itemList) {
            double tax = taxCalculator.calculateTax(item);
            receipt.addItem(item, tax);
        }

        receipt.printReceipt();
    }



    public static SalesAppHandler getAppInstance() {
        return appInstance.get();
    }

    public static void flushInstance() {
        appInstance.remove();
    }
}
