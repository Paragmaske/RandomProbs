package Streams;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}

class Order {
    private int id;
    private Custom customer;
    private List<Product> products;

    public Order(int id, Custom customer, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Custom getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", products=" + products + "]";
    }

}

class Custom {
    private int id;
    private String name;
    private String email;

    public Custom(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Custom [id=" + id + ", name=" + name + ", email=" + email + "]";
    }

}
public class ProductFilters {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product(1, "Product A", 10.99), new Product(2, "Product B", 9.99),
                new Product(3, "Product C", 12.99), new Product(4, "Product D", 8.99));

        List<Custom> customers = Arrays.asList(new Custom(1, "John Doe", "john@doe.com"),
                new Custom(2, "Bob Smith", "john@example.com"), new Custom(3, "Natsu Dragneel", "nalu@example.com"),
                new Custom(4, "John Wick", "john@wick.com"), new Custom(5, "Lucy Heartfilia", "lucy@dragneel.com"));

        List<Order> orders = Arrays.asList(
                new Order(1, customers.get(0), Arrays.asList(products.get(0), products.get(1))),
                new Order(2, customers.get(1), Arrays.asList(products.get(2), products.get(3))),
                new Order(3, customers.get(1), Arrays.asList(products.get(1), products.get(2))),
                new Order(4, customers.get(2), Arrays.asList(products.get(0), products.get(3))));


// orders.stream()
//         .collect(Collectors.groupingBy(Order::getCustomer))
//         .entrySet()
//         .stream()
//         .map(x-> x.getValue().stream().flatMap())


        Map<String, Integer> collect3 = orders.stream()
                .flatMap(x -> x.getProducts().stream().map(a -> new PC(a, x.getCustomer())))
                .peek(x-> System.out.println(x.toString()))
                .collect(Collectors.groupingBy(pc -> pc.getProduct().getName(),
                        Collectors.mapping(x -> x.getCustomer().getName(), Collectors.toSet())))
                .entrySet().stream().collect(Collectors.filtering(x -> x.getValue().size() > 1,
                        Collectors.toMap(x -> x.getKey(), x -> x.getValue().size())));

        System.out.println(" =000000000000000000000000000");
        //Set<Product> productsOrderedByMultipleCustomers = orders.stream();

    }


}

class PC{
    Product product;
    Custom customer;

    public Custom getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCustomer(Custom customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "PC{" +
                "product=" + product +
                ", customer=" + customer +
                '}';
    }

    public PC(Product product, Custom customer) {
        this.product = product;
        this.customer = customer;
    }
}


