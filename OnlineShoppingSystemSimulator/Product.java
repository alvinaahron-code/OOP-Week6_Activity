package OnlineShoppingSystemSimulator;
import Payments.*;

public abstract class Product {
    protected String name;
    protected double price;
    protected String brand;
    protected int stockQuantity;


    public Product (String name, double price, String brand, int stockQuantity) {
        setPrice(price);
        setBrand(brand);
        setName(name);
        setStockQuantity(stockQuantity);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity <= 0) {
            throw new IllegalArgumentException("Stock quantity must be greater than 0.");
        }
        this.stockQuantity = stockQuantity;
    }

    public abstract double calculateDiscount();

    @Override
    public String toString() {
        return "Product Name: " + name + "\nPrice: " + price + "\nBrand: " + brand + "\nStock Quantity " + stockQuantity;
    }

}
