package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import consumables.Size;
import consumables.builders.Meal;
import consumables.builders.MealBuilder;
import consumables.food.Food;
import consumables.decorators.*;
import consumables.factories.FactoryProducer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import prototype.MealStore;

public class MealController implements Initializable , ControlledScreen
{
    @FXML private AnchorPane rootPane;
    @FXML private Label paneTitle;
    @FXML private VBox foodChoice;
    @FXML private VBox sideChoice;
    @FXML private VBox drinkChoice;
    @FXML private Button backButton;
    private ScreensController myController;

    private ConsumableFactory foodFactory;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        foodFactory = FactoryProducer.getFactory(Consumables.FOOD);
    }

    public void setScreenParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    @FXML
    private void goToMainMenu(ActionEvent event)
    {
        ((Button)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void getBeefBurgerMeal(ActionEvent event)
    {
        MealBuilder mealBuilder = new MealBuilder();
        Meal beefBurgerMeal = mealBuilder.prepareBeefBurgerMeal();
        addFood(beefBurgerMeal);
    }

    @FXML
    private void getDoubleBeefBurgerMeal(ActionEvent e){
        MealBuilder mealBuilder = new MealBuilder();
        Meal beefBurgerMeal = mealBuilder.prepareBeefBurgerMeal();
        addFood(beefBurgerMeal);

        //Use Prototype pattern to clone earlier meal
        MealStore mealStore = new MealStore();
        mealStore.load();
        Meal beefBurgerMealClone = mealStore.getMeal("Beef Burger Meal");
        addFood(beefBurgerMealClone);
    }

    @FXML
    private void getKebabMeal(ActionEvent event)
    {
        MealBuilder mealBuilder = new MealBuilder();
        Meal kebabMeal = mealBuilder.prepareKebabMeal();
        addFood(kebabMeal);
    }

    @FXML
    private void getDoubleKebabMeal(ActionEvent event)
    {
        MealBuilder mealBuilder = new MealBuilder();
        Meal kebabMeal = mealBuilder.prepareKebabMeal();
        addFood(kebabMeal);

        //Use Prototype pattern to clone earlier meal
        MealStore mealStore = new MealStore();
        mealStore.load();
        Meal kebabMealClone = mealStore.getMeal("Kebab Meal");
        addFood(kebabMealClone);
    }

    private void addFood(Food foodType, Size size)
    {
        Consumable food = foodFactory.getFood();
        food = foodFactory.addFood(foodType, food);
        myController.getCustomerOrder().addFood((FoodDecorator) food, size);
    }

    private void addFood(Meal mealType)
    {
       ArrayList<Consumable> contents = mealType.getContents();
        for (Consumable item : contents) {
            if (item instanceof FoodDecorator) {
                myController.getCustomerOrder().addFood((FoodDecorator) item);
            } else if (item instanceof DrinkDecorator) {
                myController.getCustomerOrder().addDrink((DrinkDecorator) item);
            } else if (item instanceof SideDecorator) {
                myController.getCustomerOrder().addSide((SideDecorator) item);
            }
        }

    }
}

