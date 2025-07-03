package com.salesTaxApp;


import com.salesTaxApp.appHandler.SalesAppHandler;

public class SalesTaxApp {
    public static void main(String[] args) {
        SalesAppHandler.getAppInstance().startApplication();
    }
}