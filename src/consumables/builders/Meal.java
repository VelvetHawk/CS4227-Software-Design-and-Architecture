package consumables.builders;

import consumables.decorators.Consumable;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
            //totalCost = totalCost - 2.0;
        }
        return totalCost;
    }

    /*public ArrayList<Consumable> getContents()
    {
        return items;
    }
    */

    public class Iterator{
         Meal meal;
         private java.util.Iterator iterator;
         private Consumable value;


         public Iterator(Meal meal){
             this.meal = meal;
         }

         public void first(){
             iterator = meal.items.iterator();
             next();
         }

         public void next(){
             try{
                 value = (Consumable)iterator.next();
             }
             catch(NoSuchElementException e){
                 value = null;
             }
         }

         public boolean isDone(){
             return value == null;
         }

         public Consumable currentValue(){
             return value;
         }



    }

    public Iterator getIterator(){
        return new Iterator(this);
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

