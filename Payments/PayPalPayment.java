package Payments;

public class PayPalPayment extends Payment implements Encryptable, Refundable {
    private String email;

    public PayPalPayment(double amount, String currency, String email) {
        super(amount, currency);
        setEmail(email);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment for account: " + email);
        setSuccess(true);
    }

    @Override
    public void encryptTransaction() {
        System.out.println("Encrypting PayPal transaction for account " + email +
                " with SSL/TLS encryption...");
    }

    @Override
    public void processRefund() {
        System.out.println("Refund of " + getAmount() + " " + getCurrency() +
                " issued to PayPal email: " + email);
        setSuccess(false);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid PayPal email.");
        }
        this.email = email;
    }
}
