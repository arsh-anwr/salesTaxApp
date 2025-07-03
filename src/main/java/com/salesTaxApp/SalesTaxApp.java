package src.main.java.com.salesTaxApp;

import src.main.java.com.salesTaxApp.appHandler.SalesAppHandler;

public class SalesTaxApp {
    public static void main(String[] args) {
        SalesAppHandler.getAppInstance().startApplication();
    }
}