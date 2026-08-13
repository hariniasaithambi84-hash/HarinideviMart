import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class HariniMart {
    static Scanner sc = new Scanner(System.in);
    static Product[] products = new Product[50];
    static int count = 0;

    // Add Product
    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        products[count++] = new Product(id, name, price, quantity);

        System.out.println("Product added successfully!");
    }

    // Display Products
    static void displayProducts() {
        if (count == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--------- HARINI MART ---------");
        System.out.println("ID\tName\t\tPrice\tQuantity");

        for (int i = 0; i < count; i++) {
            System.out.println(
                products[i].id + "\t" +
                products[i].name + "\t\t" +
                products[i].price + "\t" +
                products[i].quantity
            );
        }
    }

    // Search Product
    static void searchProduct() {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                System.out.println("\nProduct Found!");
                System.out.println("Name     : " + products[i].name);
                System.out.println("Price    : " + products[i].price);
                System.out.println("Quantity : " + products[i].quantity);
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // Generate Bill
    static void generateBill() {
        double total = 0;

        System.out.println("\n--------- HARINI MART BILL ---------");

        while (true) {
            System.out.print("Enter Product ID (0 to finish): ");
            int id = sc.nextInt();

            if (id == 0)
                break;

            Product selected = null;

            for (int i = 0; i < count; i++) {
                if (products[i].id == id) {
                    selected = products[i];
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Product not found!");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            if (qty > selected.quantity) {
                System.out.println("Insufficient stock!");
            } else {
                double amount = selected.price * qty;
                total += amount;
                selected.quantity -= qty;

                System.out.println(
                    selected.name + " x " + qty +
                    " = Rs." + amount
                );
            }
        }

        System.out.println("------------------------------------");
        System.out.println("Total Amount : Rs." + total);
        System.out.println("Thank you for shopping at Harini Mart!");
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("       WELCOME TO HARINI MART");
            System.out.println("================================");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    generateBill();
                    break;

                case 5:
                    System.out.println("Thank you! Visit Harini Mart again.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}