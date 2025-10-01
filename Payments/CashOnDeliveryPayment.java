package Payments;

public class CashOnDeliveryPayment extends Payment {
    private String deliveryAddress;

    public CashOnDeliveryPayment(double amount, String currency, String deliveryAddress) {
        super(amount, currency);
        setDeliveryAddress(deliveryAddress);
    }

    @Override
    public void processPayment() {
        System.out.println("Cash on Delivery selected. Pay upon delivery at: " + deliveryAddress);
        setSuccess(true);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        if (deliveryAddress == null || deliveryAddress.isBlank()) {
            throw new IllegalArgumentException("Delivery address cannot be blank.");
        }
        this.deliveryAddress = deliveryAddress;
    }
}
