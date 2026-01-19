package model;

import javafx.beans.property.*;

public class Product {

    private final StringProperty name = new SimpleStringProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();
    private final IntegerProperty quantity = new SimpleIntegerProperty();
    private final StringProperty barcode = new SimpleStringProperty();

    public Product(String name, double price, int quantity, String barcode) {
        this.name.set(name);
        this.price.set(price);
        this.quantity.set(quantity);
        this.barcode.set(barcode);
    }

    public StringProperty nameProperty() { return name; }
    public DoubleProperty priceProperty() { return price; }
    public IntegerProperty quantityProperty() { return quantity; }
    public StringProperty barcodeProperty() { return barcode; }

    public String getName() { return name.get(); }
    public double getPrice() { return price.get(); }
    public int getQuantity() { return quantity.get(); }
    public String getBarcode() { return barcode.get(); }

    public void setPrice(double price) { this.price.set(price); }
    public void setQuantity(int quantity) { this.quantity.set(quantity); }
}