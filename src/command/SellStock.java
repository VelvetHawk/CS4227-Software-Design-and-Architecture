package command;

public class SellStock implements StockOrder
{
    private Stock stock;

    public SellStock(Stock stock)
    {
        this.stock = stock;
    }
    public void execute()
    {
        stock.sell();
    }
}