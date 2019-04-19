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

public class ConsumableDescriptionVisitor implements ConsumableVisitor
{
    @Override
    public String visit(Burger burger)
    {
        return "Delicious Conor made beef burger made with 100% beef from Conors farm";
    }

    @Override
    public String visit(Kebab kebab)
    {
         return "Middle Eastern style Meat dish";
    }

    @Override
    public String visit(ChickenBurger chickenBurger)
    {
        return "Delicious chicken breast sandwich";
    }

    @Override
    public String visit(BasicFood basicFood)
    {
        return "Delicious food";
    }

    @Override
    public String visit(BasicDrink basicDrink)
    {
        return "Delicious drink";
    }

    @Override
    public String visit(BasicSide basicSide)
    {
        return "Delicious side";
    }

    @Override
    public String visit(BasicTopping basicTopping)
    {
        return "Delicious topping";
    }

    @Override
    public String visit(ClubOrange clubOrange)
    {
        return "Delicious club orange";
    }

    @Override
    public String visit(CocaCola cocaCola)
    {
        return "Delicious coca cola";
    }

    @Override
    public String visit(DietCocaCola dietCocaCola)
    {
        return "Delicious diet coca cola";
    }

    @Override
    public String visit(Pepsi pepsi)
    {
        return "Delicious pepsi";
    }

    @Override
    public String visit(PepsiMax pepsiMax)
    {
        return "Delicious pepsi max";
    }

    @Override
    public String visit(SevenUp sevenUp)
    {
        return "Delicious seven up";
    }

    @Override
    public String visit(Sprite sprite)
    {
        return "Delicious sprite";
    }

    @Override
    public String visit(Water water)
    {
        return "Delicious water";
    }

    @Override
    public String visit(Pizza pizza)
    {
        return "Delicious pizza";
    }

    @Override
    public String visit(Beans beans)
    {
        return "Delicious beans";
    }

    @Override
    public String visit(Chips chips)
    {
        return "Delicious chips";
    }

    @Override
    public String visit(Coleslaw coleslaw)
    {
        return "Delicious coleslaw";
    }

    @Override
    public String visit(GarlicBread garlicBread)
    {
        return "Delicious garlic bread";
    }

    @Override
    public String visit(OnionRings onionRings)
    {
        return "Delicious onion rings";
    }

    @Override
    public String visit(Beef beef)
    {
        return "Delicious beef";
    }

    @Override
    public String visit(Cheese cheese)
    {
        return "Delicious cheese";
    }

    @Override
    public String visit(Chicken chicken)
    {
        return "Delicious chicken";
    }

    @Override
    public String visit(Ham ham)
    {
        return "Delicious ham";
    }

    @Override
    public String visit(Mushroom mushroom)
    {
        return "Delicious mushroom";
    }

    @Override
    public String visit(Pepperoni pepperoni)
    {
        return "Delicious pepperoni";
    }

    @Override
    public String visit(Pineapple pineapple)
    {
        return "Delicious pineapple";
    }

    @Override
    public String visit(Sausage sausage)
    {
        return "Delicious sausage";
    }
}
