package visitor;

import consumables.basics.BasicDrink;
import consumables.basics.BasicFood;
import consumables.basics.BasicSide;
import consumables.basics.BasicTopping;
import consumables.decorators.Consumable;
import consumables.drinks.*;
import consumables.food.Burger;
import consumables.food.ChickenBurger;
import consumables.food.Kebab;
import consumables.food.Pizza;
import consumables.side.*;
import consumables.toppings.*;

public class ConsumableDescriptionVisitor implements ConsumableVisitor {

    @Override
    public String visit(Burger burger){
        String burgerDesc = "Delicious mode-made beef burger made with 100% Irish beef";
        return burgerDesc;
    }

    @Override
    public String visit(Kebab kebab){
         return "Middle Eastern style Meat dish";
    }

    @Override
    public String visit(ChickenBurger chickenBurger){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(BasicFood basicFood){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(BasicDrink basicDrink){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(BasicSide basicSide){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(BasicTopping basicTopping){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(ClubOrange clubOrange){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(CocaCola cocaCola){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(DietCocaCola dietCocaCola){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Pepsi pepsi){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(PepsiMax pepsiMax){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(SevenUp sevenUp){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Sprite sprite){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Water water){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Pizza pizza){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Beans beans){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Chips chips){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Coleslaw coleslaw){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(GarlicBread garlicBread){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(OnionRings onionRings){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Beef beef){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Cheese cheese){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Chicken chicken){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Ham ham){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Mushroom mushroom){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Pepperoni pepperoni){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Pineapple pineapple){
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(Sausage sausage){
        return "Delicious chicken breast sandwich";
    }

}
