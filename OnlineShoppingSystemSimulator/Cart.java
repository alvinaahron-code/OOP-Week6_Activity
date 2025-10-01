package OnlineShoppingSystemSimulator;

import java.util.ArrayList;
import java.util.List;

public abstract class Cart extends Product implements CartOperations{
    private String ownerName;

    private List<Product> products = new ArrayList<>();

    public Cart (String name, String brand, int stockQuantity, double price, String ownerName) {
        super(name, price, brand, stockQuantity);
        setOwnerName(ownerName);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isEmpty()) {
            throw new IllegalArgumentException("Card holder name cannot be blank.");
        }
        this.ownerName = ownerName;
    }

    public void addProduct() {
        System.out.println("Product: " + name + " has been added to cart!");
    }

    public void removeProduct() {
        System.out.println("Product: " + name + " has been removed to cart.");
    }

    @Override
    public double calculateTotal() {
        double total = 0;
        for(Product p : products) {
            total += p.calculateDiscount();
        }
        return total;
    }

    public void printCartSummary(){
        System.out.printf("Product:          %s", name);
        System.out.printf("Brand:            %s", brand);
        System.out.printf("Stock Quantity:   %d", stockQuantity);
        System.out.printf("Price:            %.2f", price);
        System.out.printf("Owner:            %s", ownerName);
    }

}
