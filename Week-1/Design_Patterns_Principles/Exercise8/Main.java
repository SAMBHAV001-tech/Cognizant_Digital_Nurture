public class Main {
    public static void main(String[] args) {
        PaymentContext ctx = new PaymentContext();

        System.out.println("--- Paying with Credit Card ---");
        ctx.setStrategy(new CreditCardPayment("1234567890124567"));
        ctx.executePayment(500.00);

        System.out.println("\n--- Switching to PayPal ---");
        ctx.setStrategy(new PayPalPayment("user@example.com"));
        ctx.executePayment(250.75);

        System.out.println("\n--- Switching back to Credit Card ---");
        ctx.setStrategy(new CreditCardPayment("9876543210987654"));
        ctx.executePayment(120.00);
    }
}
