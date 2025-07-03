# 🧾 Sales Tax App

A clean, modular, and production-grade **Java console application** that calculates sales tax and prints receipts according to the specified rules. Designed with extensibility, testability, and maintainability in mind — ideal for interviews and real-world billing systems.

---

## 📌 Problem Statement

Given a list of purchased items with descriptions and prices, the app:
- Applies **basic sales tax** (10%) to all goods except **books, food, and medical products**.
- Applies **import duty** (5%) to all **imported** goods.
- Rounds tax to the **nearest 0.05**.
- Outputs a receipt showing individual item totals, total tax, and grand total.

---

## 💡 Features

- ✅ Object-Oriented Design (SOLID principles)
- ✅ Strategy pattern for tax rule extensibility
- ✅ Keyword-based exemption classification
- ✅ Handles multi-line or single-line inputs
- ✅ JUnit 5 test coverage for receipt accuracy
- ✅ Maven project with clear folder structure

---

## 📂 Project Structure

```
src/
├── main/
│   └── java/com/salesTaxApp/
│       ├── SalesTaxApp.java         # Entry point
│       ├── model/                   # Item, ReceiptLineItem
│       ├── receipt/                 # Receipt logic
│       ├── tax/                     # Tax rules and calculator
│       ├── classifier/              # Exemption rules
│       └── input/                   # Item parsing
├── test/
│   └── java/com/salesTaxApp/
│       └── ReceiptTest.java         # Sample input/output tests
```

---

## 🚀 How to Run

### ✅ Via Terminal

```bash
git clone https://github.com/arsh-anwr/salesTaxApp.git
cd salesTaxApp
mvn compile
mvn exec:java -Dexec.mainClass="com.salesTaxApp.SalesTaxApp"
```

### ✅ Via IntelliJ / Eclipse
- Open the project as a Maven project
- Run `SalesTaxApp.main()` directly

---

## ✍️ Sample Input (Console)

```
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25
```

(write exit at the end )

---

## ✅ Sample Output

```
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 box of imported chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
```

---

## 🧪 Run Tests

```bash
mvn test
```

Covers all sample scenarios with accurate tax + total validation.

---

## 🔧 Tech Stack

- Java 17+
- Maven
- JUnit 5

---

## 📄 License

This project is provided under the [MIT License](LICENSE).