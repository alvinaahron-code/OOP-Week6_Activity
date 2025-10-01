package OnlineShoppingSystemSimulator;

public class Electronics extends Product implements Discountable, Returnable {
    private int warrantyPeriod;
    private String powerUsage;

    public Electronics (String name, double price, String brand, int stockQuantity, int warrantyPeriod, String powerUsage) {
        super(name, price, brand, stockQuantity);
        setWarrantyPeriod(warrantyPeriod);
        setPowerUsage(powerUsage);
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        if (warrantyPeriod <= 0) {
            throw new IllegalArgumentException("Warranty period must be greater than 0.");
        }
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(String powerUsage) {
        this.powerUsage = powerUsage;
    }

    @Override
    public void returnItem(){
        System.out.println("Product: " + name + " is being processed for return.");
    }

    @Override
    public double calculateDiscount(){
        return price * 0.10;
    }

    @Override
    public void applyDiscount() {

    }
}
