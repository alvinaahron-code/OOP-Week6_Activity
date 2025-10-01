package OnlineShoppingSystemSimulator;

public class Clothing extends Product implements Discountable, Returnable {
    private int size;
    private String color;

    public Clothing (String name, double price, String brand, int stockQuantity, int size, String color) {
        super(name, price, brand, stockQuantity);
        setSize(size);
        setColor(color);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void returnItem(){
        System.out.println("Product: " + name + " is being processed for return.");
    }

    @Override
    public double calculateDiscount(){
        return price * 0.20;
    }

    @Override
    public void applyDiscount() {

    }
}
