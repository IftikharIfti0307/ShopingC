import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<Product> products;

    public Order(int id, Customer customer, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<Product> getProducts() { return products; }

    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", products=" + products + "]";
    }
}
