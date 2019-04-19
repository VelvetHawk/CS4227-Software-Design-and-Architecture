package command;

public class BuyStock implements StockOrder
{
    private Stock stock;

    public BuyStock(Stock stock)
    {
        this.stock = stock;
    }
    public void execute()
    {
        stock.buy();
    }
}