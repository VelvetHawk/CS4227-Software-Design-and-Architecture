package visitor;

import consumables.decorators.Consumable;
import consumables.decorators.ConsumableFactory;
import consumables.decorators.Consumables;
import consumables.factories.FactoryProducer;
import consumables.food.Food;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumableDescriptionVisitorTest {

    private ConsumableFactory foodFactory;

    @Test
    public void testBurgerVisitor()
    {
        ConsumableDescriptionVisitor visitor = new ConsumableDescriptionVisitor();
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(Food.BURGER, food);
        String description = food.accept(visitor);
        assertEquals(description, "Delicious Conor made beef burger made with 100% beef from Conors farm");
    }

    @Test
    public void testKebabVisitor()
    {
        ConsumableDescriptionVisitor visitor = new ConsumableDescriptionVisitor();
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(Food.KEBAB, food);
        String description = food.accept(visitor);
        assertEquals(description, "Middle Eastern style Meat dish");
    }
}