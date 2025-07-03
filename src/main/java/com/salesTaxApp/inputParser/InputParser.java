package src.main.java.com.salesTaxApp.inputParser;

import java.util.Scanner;

public class InputParser {
    public String readItemLinesFromConsole() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();

        System.out.println("Paste items (type 'exit' in next line to finish):");

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            if (!line.isEmpty()) {
                inputBuilder.append(" ").append(line);
            }
        }

        return inputBuilder.toString().trim();
    }
}
