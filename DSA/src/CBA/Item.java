package CBA;

public class Item {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String supplier;

    public Item(String id, String name, int quantity, double price, String supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Item{id='" + id + "', name='" + name + "', quantity=" + quantity + ", price=" + price + ", supplier='" + supplier + "'}";
    }
}