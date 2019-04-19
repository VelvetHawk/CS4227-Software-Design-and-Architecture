package consumables.builders;

import consumables.decorators.Consumable;
import prototype.Prototype;
import java.util.ArrayList;

public class Meal extends Prototype
{
    private ArrayList<Consumable> items = new ArrayList<>();

    public void addItem(Consumable item)
    {
        items.add(item);
    }

    public double getCost()
    {
        double totalCost = 0;
        for (Consumable item : items)
        {
            double cost = item.getCost();
            totalCost += cost;
        }
        return totalCost;
    }

    public ArrayList<Consumable> getContents()
    {
        return items;
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException
    {
          return super.clone();
    }
}

