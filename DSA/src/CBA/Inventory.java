package CBA;
import java.util.ArrayList;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItem(String id, int quantity, double price, String supplier) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                item.setQuantity(quantity);
                item.setPrice(price);
                item.setSupplier(supplier);
            }
        }
    }

    public void deleteItem(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    public Item searchItemById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public Item searchItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void displayAllItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}