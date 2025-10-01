package OnlineShoppingSystemSimulator;
import Payments.Payment;

public abstract class Order implements Trackable, Cancelable{
    private Cart cart;
    private static int counter = 1000;
    private Payment payment;
    private String orderId;
    private String status;

    public Order (Payment payment, Cart cart){
        setCart(cart);
        this.orderId = "ORD" + (++counter);
        setPayment(payment);
        setStatus("Pending");
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void placeOrder() {
        System.out.println("Order: #" + orderId + " has been added to placed!");
    }
}
