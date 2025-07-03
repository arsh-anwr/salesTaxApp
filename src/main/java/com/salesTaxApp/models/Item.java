package src.main.java.com.salesTaxApp.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Item {
    String name;
    double price;
    boolean isImported;
    boolean isExempted;
    int quantity;
}
