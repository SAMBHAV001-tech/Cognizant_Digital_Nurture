public class Main {
    public static void main(String[] args) {
        PaymentProcessor p1 = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor p2 = new StripeAdapter(new StripeGateway());
        PaymentProcessor p3 = new RazorpayAdapter(new RazorpayGateway());

        System.out.println("--- Processing Payments via Adapters ---");
        p1.processPayment(250.00);
        p2.processPayment(180.50);
        p3.processPayment(320.75);
    }
}
