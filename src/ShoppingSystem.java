import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingSystem {
    private static List<Product> products = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Add Customer");
            System.out.println("3. Create Order");
            System.out.println("4. View All Products");
            System.out.println("5. View All Customers");
            System.out.println("6. View All Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: addCustomer(); break;
                case 3: createOrder(); break;
                case 4: viewAllProducts(); break;
                case 5: viewAllCustomers(); break;
                case 6: viewAllOrders(); break;
                case 7: System.exit(0); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        products.add(new Product(id, name, price));
        System.out.println("Product added successfully.");
    }

    private static void addCustomer() {
        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        customers.add(new Customer(id, name));
        System.out.println("Customer added successfully.");
    }

    private static void createOrder() {
        System.out.print("Enter order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        Customer customer = customers.stream()
                .filter(c -> c.getId() == customerId)
                .findFirst()
                .orElse(null);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter product IDs (comma separated): ");
        String[] productIds = scanner.nextLine().split(",");
        List<Product> orderProducts = new ArrayList<>();

        for (String productId : productIds) {
            Product product = products.stream()
                    .filter(p -> p.getId() == Integer.parseInt(productId))
                    .findFirst()
                    .orElse(null);

            if (product != null) {
                orderProducts.add(product);
            }
        }

        orders.add(new Order(id, customer, orderProducts));
        System.out.println("Order created successfully.");
    }

    private static void viewAllProducts() {
        products.forEach(System.out::println);
    }

    private static void viewAllCustomers() {
        customers.forEach(System.out::println);
    }

    private static void viewAllOrders() {
        orders.forEach(System.out::println);
    }
}
