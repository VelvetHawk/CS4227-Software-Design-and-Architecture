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

public interface ConsumableVisitor {
    public String visit(Burger burger);
    public String visit(Kebab kebab);
    public String visit(ChickenBurger chickenBurger);
    public String visit(ClubOrange clubOrange);
    public String visit(CocaCola cocaCola);
    public String visit(DietCocaCola dietCocaCola);
    public String visit(Pepsi pepsi);
    public String visit(PepsiMax pepsiMax);
    public String visit(SevenUp sevenUp);
    public String visit(Sprite sprite);
    public String visit(Water water);
    public String visit(Pizza pizza);
    public String visit(Beans beans);
    public String visit(Chips chips);
    public String visit(Coleslaw coleslaw);
    public String visit(GarlicBread garlicBread);
    public String visit(OnionRings onionRings);
    public String visit(Beef beef);
    public String visit(Cheese cheese);
    public String visit(Chicken chicken);
    public String visit(Ham ham);
    public String visit(Mushroom mushroom);
    public String visit(Pepperoni pepperoni);
    public String visit(Pineapple pineapple);
    public String visit(Sausage sausage);
    public String visit(BasicFood basicFood);
    public String visit(BasicDrink basicDrink);
    public String visit(BasicSide basicSide);
    public String visit(BasicTopping basicTopping);




}
