package Payments;

public abstract class Payment {
    private static int counter = 1000;
    private final String transactionId;
    protected double amount;
    protected String currency;
    private boolean isSuccess;

    public Payment(double amount, String currency) {
        setAmount(amount);
        setCurrency(currency);
        this.transactionId = "TXN" + (++counter);
        this.isSuccess = false;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency cannot be null or blank.");
        }
        this.currency = currency;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    protected void setSuccess(boolean success) {
        this.isSuccess = success;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public abstract void processPayment();

    @Override
    public String toString() {
        return "TransactionID: " + transactionId + ", Amount: " + amount +
                " " + currency + ", Success: " + isSuccess;
    }
}
