package consumables.builders;

import consumables.decorators.Consumable;

import java.util.ArrayList;

public class Meal implements Cloneable
{
    private ArrayList<Consumable> items = new ArrayList<>();
    private String name;

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
            totalCost = totalCost - 2.0;
        }
        return totalCost;
    }

    public ArrayList<Consumable> getContents()
    {
        return items;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    //Override the built-in equal operation to compare by value using == rather than compare by identity
    @Override
    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }
        return false;
    }

    @Override
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return clone;
    }
}

