public class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("WebApp Dashboard: " + stockName + " updated to $" + price);
    }
}
