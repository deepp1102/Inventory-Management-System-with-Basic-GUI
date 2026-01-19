# Inventory Management System (JavaFX)

A desktop-based Inventory Management System built using **JavaFX** that allows users to manage products with features like adding, deleting, searching, and highlighting low-stock items.  
This project was developed as part of an **internship assignment** to demonstrate core Java, JavaFX, and software engineering concepts.

---

## ✨ Features

- Add new products (Name, Price, Quantity, Barcode)
- Delete selected products
- Display inventory in a TableView
- Real-time search and filter (O(n) in-memory filtering)
- Low-stock alert (rows highlighted in red when quantity < 5)
- Form validation to prevent invalid inputs
- Singleton-based inventory manager
- Clean and simple JavaFX GUI

---

## 🧠 Core Concepts Demonstrated

- **JavaFX Data Binding** using Properties (`StringProperty`, `IntegerProperty`, etc.)
- **Singleton Design Pattern** for centralized inventory management
- **Search & Filter Algorithms** with linear time complexity
- **Form Validation** and prevention of negative stock
- **Conditional Formatting** for low-stock alerts
- Modular project structure with clear separation of concerns

---
## 🛠️ Technologies Used

- Java 24  
- JavaFX 25 (SDK)  
- VS Code  
- macOS (Apple Silicon)

## ▶️ How to Run (macOS)

### 1. Prerequisites

- Java JDK 17+ (Tested on Java 24)
- JavaFX SDK installed (Tested with JavaFX 25 aarch64)

### 2. Compile the Project

From the project root directory:

javac \
-d bin \
--module-path /Users/deep11/Downloads/javafx-sdk-25.0.1/lib \
--add-modules javafx.controls \
src/model/Product.java \
src/service/InventoryManager.java \
src/util/ValidationUtil.java \
src/ui/InventoryApp.java

### Run the Application
java \
--module-path /Users/deep11/Downloads/javafx-sdk-25.0.1/lib \
--add-modules javafx.controls \
-cp bin \
ui.InventoryApp
