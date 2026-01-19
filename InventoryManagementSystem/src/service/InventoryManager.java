package service;

import javafx.collections.*;
import model.Product;

public class InventoryManager {

    private static InventoryManager instance;
    private final ObservableList<Product> products = FXCollections.observableArrayList();

    private InventoryManager() {}

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void deleteProduct(Product p) {
        products.remove(p);
    }
}