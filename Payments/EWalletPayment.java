package Payments;

public class EWalletPayment extends Payment implements Rewardable {
    private String walletId;

    public EWalletPayment(double amount, String currency, String walletId) {
        super(amount, currency);
        setWalletId(walletId);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing E-Wallet payment with Wallet ID: " + walletId);
        setSuccess(true);
    }

    @Override
    public void giveRewards() {
        int points = (int)(getAmount() / 50);
        System.out.println("E-Wallet payment earned " + points + " reward points.");
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        if (walletId == null || walletId.isBlank()) {
            throw new IllegalArgumentException("Wallet ID cannot be blank.");
        }
        this.walletId = walletId;
    }
}
