import java.util.ArrayList;

public class StockMarket implements Stock {
    private ArrayList<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void register(Observer o) {
        observers.add(o);
        System.out.println(o.getClass().getSimpleName() + " registered for " + stockName);
    }

    public void remove(Observer o) {
        observers.remove(o);
        System.out.println(o.getClass().getSimpleName() + " removed from " + stockName);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("\n" + stockName + " price changed to " + price);
        notifyObservers();
    }
}
