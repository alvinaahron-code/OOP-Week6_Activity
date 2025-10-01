package Payments;

public class BDOInstallmentsPayment extends Payment implements Encryptable {
    private int months;
    private double monthlyRate;

    public BDOInstallmentsPayment(double amount, String currency, int months, double monthlyRate) {
        super(amount, currency);
        setMonths(months);
        setMonthlyRate(monthlyRate);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing BDO Installments payment: " + months +
                " months at " + monthlyRate + "% monthly interest.");
        setSuccess(true);
    }

    @Override
    public void encryptTransaction() {
        System.out.println("Encrypting BDO installment plan (" + months +
                " months, " + monthlyRate + " rate) with digital signature...");
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Months must be greater than 0.");
        }
        this.months = months;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        if (monthlyRate < 0) {
            throw new IllegalArgumentException("Monthly rate cannot be negative.");
        }
        this.monthlyRate = monthlyRate;
    }
}
