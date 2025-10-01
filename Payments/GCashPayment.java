package Payments;

public class GCashPayment extends Payment implements Refundable {
    private String mobileNumber;

    public GCashPayment(double amount, String currency, String mobileNumber) {
        super(amount, currency);
        setMobileNumber(mobileNumber);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing GCash payment from mobile number: " + mobileNumber);
        setSuccess(true);
    }

    @Override
    public void processRefund() {
        System.out.println("Refund of " + getAmount() + " " + getCurrency() +
                " sent back to GCash account: " + mobileNumber);
        setSuccess(false);
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        if (mobileNumber == null || mobileNumber.length() < 11) {
            throw new IllegalArgumentException("Invalid mobile number.");
        }
        this.mobileNumber = mobileNumber;
    }
}
