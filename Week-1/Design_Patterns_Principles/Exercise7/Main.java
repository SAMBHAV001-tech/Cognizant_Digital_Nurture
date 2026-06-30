public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket("AAPL", 150.00);

        MobileApp mobile = new MobileApp();
        WebApp web = new WebApp();

        market.register(mobile);
        market.register(web);

        market.setPrice(155.50);
        market.setPrice(148.20);

        System.out.println("\n--- Removing MobileApp ---");
        market.remove(mobile);

        market.setPrice(160.00);
    }
}
