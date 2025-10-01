package Payments;

public class CreditDebitPayment extends Payment implements Encryptable, Refundable, Rewardable {
    private String cardNumber;
    private String cardHolderName;

    public CreditDebitPayment(double amount, String currency, String cardNumber, String cardHolderName) {
        super(amount, currency);
        setCardNumber(cardNumber);
        setCardHolderName(cardHolderName);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 12) {
            throw new IllegalArgumentException("Invalid card number.");
        }
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        if (cardHolderName == null || cardHolderName.isBlank()) {
            throw new IllegalArgumentException("Card holder name cannot be blank.");
        }
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Credit/Debit payment for card: **** **** **** "
                + cardNumber.substring(cardNumber.length() - 4));
        setSuccess(true);
    }

    @Override
    public void encryptTransaction() {
        String maskedCard = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Encrypting card transaction for " + maskedCard + " using AES-256...");
    }

    @Override
    public void processRefund() {
        System.out.println("Refund of " + getAmount() + " " + getCurrency() +
                " initiated to Credit/Debit card ending in " +
                cardNumber.substring(cardNumber.length() - 4));
        setSuccess(false);
    }

    @Override
    public void giveRewards() {
        int points = (int)(getAmount() / 100);
        System.out.println("Credit/Debit payment earned " + points + " reward points.");
    }
}
