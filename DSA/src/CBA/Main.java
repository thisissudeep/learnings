package CBA;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadInventory();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Items");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: addItem(); break;
                case 2: updateItem(); break;
                case 3: deleteItem(); break;
                case 4: searchItem(); break;
                case 5: displayAllItems(); break;
                case 6: saveAndExit(); return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter supplier: ");
        String supplier = scanner.nextLine();

        Item item = new Item(id, name, quantity, price, supplier);
        inventory.addItem(item);
        System.out.println("Item added successfully.");
    }

    private static void updateItem() {
        System.out.print("Enter item ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter new supplier: ");
        String supplier = scanner.nextLine();

        inventory.updateItem(id, quantity, price, supplier);
        System.out.println("Item updated successfully.");
    }

    private static void deleteItem() {
        System.out.print("Enter item ID to delete: ");
        String id = scanner.nextLine();
        inventory.deleteItem(id);
        System.out.println("Item deleted successfully.");
    }

    private static void searchItem() {
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Item item = null;
        if (choice == 1) {
            System.out.print("Enter item ID: ");
            String id = scanner.nextLine();
            item = inventory.searchItemById(id);
        } else if (choice == 2) {
            System.out.print("Enter item name: ");
            String name = scanner.nextLine();
            item = inventory.searchItemByName(name);
        } else {
            System.out.println("Invalid option.");
        }

        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void displayAllItems() {
        inventory.displayAllItems();
    }

    private static void saveAndExit() {
        try {
            FileManager.saveToFile("inventory.dat", inventory.getItems());
            System.out.println("Inventory saved successfully. Exiting...");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    private static void loadInventory() {
        try {
            inventory.setItems(FileManager.loadFromFile("inventory.dat"));
            System.out.println("Inventory loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}