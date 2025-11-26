package gr.gkiv.orders.domain;

public class OrderItem {
    private String productName;
    private double quantity;
    private String unit;
    private String notes;

    public OrderItem(String productName, double quantity, String unit, String notes) {
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
        this.notes = notes;
    }

    public String getProductName() {
        return productName;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getNotes() {
        return notes;
    }
}
