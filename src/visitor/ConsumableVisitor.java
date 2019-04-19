package visitor;

import consumables.basics.BasicDrink;
import consumables.basics.BasicFood;
import consumables.basics.BasicSide;
import consumables.basics.BasicTopping;
import consumables.drinks.*;
import consumables.food.Burger;
import consumables.food.ChickenBurger;
import consumables.food.Kebab;
import consumables.food.Pizza;
import consumables.side.*;
import consumables.toppings.*;

public interface ConsumableVisitor {
    String visit(Burger burger);
    String visit(Kebab kebab);
    String visit(ChickenBurger chickenBurger);
    String visit(ClubOrange clubOrange);
    String visit(CocaCola cocaCola);
    String visit(DietCocaCola dietCocaCola);
    String visit(Pepsi pepsi);
    String visit(PepsiMax pepsiMax);
    String visit(SevenUp sevenUp);
    String visit(Sprite sprite);
    String visit(Water water);
    String visit(Pizza pizza);
    String visit(Beans beans);
    String visit(Chips chips);
    String visit(Coleslaw coleslaw);
    String visit(GarlicBread garlicBread);
    String visit(OnionRings onionRings);
    String visit(Beef beef);
    String visit(Cheese cheese);
    String visit(Chicken chicken);
    String visit(Ham ham);
    String visit(Mushroom mushroom);
    String visit(Pepperoni pepperoni);
    String visit(Pineapple pineapple);
    String visit(Sausage sausage);
    String visit(BasicFood basicFood);
    String visit(BasicDrink basicDrink);
    String visit(BasicSide basicSide);
    String visit(BasicTopping basicTopping);




}
