package ui;

import javafx.application.Application;
import javafx.collections.transformation.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Product;
import service.InventoryManager;
import util.ValidationUtil;

public class InventoryApp extends Application {

    @Override
    public void start(Stage stage) {

        InventoryManager manager = InventoryManager.getInstance();

        TextField nameField = new TextField();
        TextField priceField = new TextField();
        TextField qtyField = new TextField();
        TextField barcodeField = new TextField();
        TextField searchField = new TextField();

        nameField.setPromptText("Name");
        priceField.setPromptText("Price");
        qtyField.setPromptText("Quantity");
        barcodeField.setPromptText("Barcode");
        searchField.setPromptText("Search / Barcode");

        TableView<Product> table = new TableView<>();
        table.setItems(manager.getProducts());

        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(d -> d.getValue().nameProperty());

        TableColumn<Product, Number> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(d -> d.getValue().priceProperty());

        TableColumn<Product, Number> qtyCol = new TableColumn<>("Quantity");
        qtyCol.setCellValueFactory(d -> d.getValue().quantityProperty());

        table.getColumns().addAll(nameCol, priceCol, qtyCol);

        // 🔴 Low Stock Highlight
        table.setRowFactory(tv -> new TableRow<>() {
            @Override
            protected void updateItem(Product item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setStyle("");
                } else if (item.getQuantity() < 5) {
                    setStyle("-fx-background-color: #ffcccc;");
                } else {
                    setStyle("");
                }
            }
        });

        Button addBtn = new Button("Add");
        Button deleteBtn = new Button("Delete");

        addBtn.setOnAction(e -> {
            if (ValidationUtil.isValid(nameField.getText(), priceField.getText(), qtyField.getText())) {
                manager.addProduct(new Product(
                        nameField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(qtyField.getText()),
                        barcodeField.getText()
                ));
                nameField.clear();
                priceField.clear();
                qtyField.clear();
                barcodeField.clear();
            }
        });

        deleteBtn.setOnAction(e -> {
            Product selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) manager.deleteProduct(selected);
        });

        // 🔍 Search / Barcode filter (O(n))
        FilteredList<Product> filtered = new FilteredList<>(manager.getProducts(), p -> true);
        searchField.textProperty().addListener((obs, old, text) -> {
            filtered.setPredicate(p ->
                p.getName().toLowerCase().contains(text.toLowerCase()) ||
                p.getBarcode().contains(text)
            );
        });
        table.setItems(filtered);

        HBox form = new HBox(10, nameField, priceField, qtyField, barcodeField, addBtn, deleteBtn);
        VBox root = new VBox(10, searchField, form, table);
        root.setPadding(new Insets(15));

        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Inventory Management System");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}