package consumables.builders;

import consumables.decorators.Consumable;
import prototype.Prototype;
import java.util.ArrayList;

public class Meal extends Prototype{
    ArrayList<Consumable> items = new ArrayList<Consumable>();

    public void addItem(Consumable item){
        items.add(item);
    }

    public double getCost(){
        double totalCost = 0;
        for(int i=0;i<items.size();i++){
            Consumable item = items.get(i);
            double cost = item.getCost();
            totalCost+= cost;
        }
        return totalCost;
    }

    public ArrayList<Consumable> getContents(){
        return items;
    }

    public Prototype clone() throws CloneNotSupportedException{
          return super.clone();
    }
}

