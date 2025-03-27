import java.util.Arrays;
import java.util.List;
class Product {
private String name;
private int price;
private String category;
public Product(String name, int price, String category) {
this.name = name;
this.price = price;
this.category = category;
}
public String getName() {
return name;
}
public int getPrice() {
return price;
}
public String getCategory() {
return category;
}
}
public class Main {
public static void main(String[] args) {
List<Product> products = Arrays.asList(
new Product("Laptop", 1500, "Electronics"),
new Product("Smartphone", 800, "Electronics"),
new Product("Refrigerator", 1200, "Appliances"),
new Product("Washing Machine", 950, "Appliances"),
new Product("Sneakers", 120, "Fashion"),
new Product("Backpack", 50, "Fashion")
);
List<Product> expensiveProducts = products.stream()
.filter(product -> product.getPrice() > 1000)
.collect(Collectors.toList());
System.out.println("Expensive Products: " + expensiveProducts);
int totalPrice = products.stream()
.mapToInt(Product::getPrice)
.sum();
System.out.println("Total Price of All Products: " + totalPrice);
Product mostExpensiveProduct = products.stream()
.max(Comparator.comparing(Product::getPrice))
.orElse(null);
System.out.println("Most Expensive Product: " + mostExpensiveProduct.getName());
List<String> sortedProductNames = products.stream().map(Product::getName)
.sorted()
.collect(Collectors.toList());
System.out.println("Sorted Product Names: " + sortedProductNames);
Map<String, Long> categoryCounts = products.stream()
.collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
System.out.println("Number of Products in Each Category: " + categoryCounts);
}
}
