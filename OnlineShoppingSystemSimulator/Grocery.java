package OnlineShoppingSystemSimulator;

public class Grocery extends Product implements Discountable, Returnable, Perishable {
    private int expiryDate;
    private boolean isPerishable;

    public Grocery (String name, double price, String brand, int stockQuantity, int expiryDate, boolean isPerishable) {
        super(name, price, brand, stockQuantity);
        setExpiryDate(expiryDate);
        this.isPerishable = false;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        if (expiryDate <= 0) {
            throw new IllegalArgumentException("Expiry date must be greater than 0.");
        }
        this.expiryDate = expiryDate;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean perishable) {
        isPerishable = perishable;
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
        System.out.println("Discount Applied: " + calculateDiscount());
    }

    @Override
    public void checkExpiry() {
        System.out.println("Expiry Date: " + expiryDate);
    }

}
