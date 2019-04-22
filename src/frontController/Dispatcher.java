package frontController;

import controllers.*;
import display.views.FrontControllScreens;
import display.views.PopUpScreens;
import display.views.Screens;

public class Dispatcher {
   private MainScreen mainScreen;
   private LoginScreen loginScreen;
   private Registration registration;
   private MakeOrderController makeOrderController;
   private MainMenu mainMenu;
   private OrderTypeChoiceController orderTypeChoiceController;
   private FoodController foodController;
   private ToppingsController toppingsController;
   private SideFoodController sideFoodController;
   private DrinksController drinksController;
   private MealController mealController;
   private ItemDescriptionController itemDescriptionController;

   public Dispatcher(){
      mainScreen = new MainScreen();
      loginScreen = new LoginScreen();
      registration = new Registration();
      makeOrderController = new MakeOrderController();
      mainMenu = new MainMenu();
      orderTypeChoiceController = new OrderTypeChoiceController();
      foodController = new FoodController();
      toppingsController = new ToppingsController();
      sideFoodController = new SideFoodController();
      drinksController = new DrinksController();
      mealController = new MealController();
      itemDescriptionController = new ItemDescriptionController();
   }

   public void dispatch( FrontControllScreens request){
//      if(request.equalsIgnoreCase("HOME")){
//         mainScreen.show();
//      }
//      else if(request.equalsIgnoreCase("LOGIN"))
//      {
//         loginScreen.show();
//      }
//      else if(request.equalsIgnoreCase("MAIN_MENU"))
//      {
//         mainMenu.show();
//      }
//      else if(request.equalsIgnoreCase("MAKE_ORDER"))
//      {
//         makeOrderController.show();
//      }
//      else if(request.equalsIgnoreCase("ORDER_TYPE"))
//      {
//         orderTypeChoiceController.show();
//      }
//      else if(request.equalsIgnoreCase("FOODS"))
//      {
//         foodController.show();
//      }
//      else if(request.equalsIgnoreCase("TOPPINGS"))
//      {
//         toppingsController.show();
//      }
//      else if(request.equalsIgnoreCase("SIDE_FOODS"))
//      {
//         sideFoodController.show();
//      }
//      else if(request.equalsIgnoreCase("DRINKS"))
//      {
//         drinksController.show();
//      }
//      else if(request.equalsIgnoreCase("MEALS"))
//      {
//         mealController.show();
//      }
//      else if(request.equalsIgnoreCase("ITEM_DESCRIPTION"))
//      {
//         itemDescriptionController.show();
//      }
//      else{
//         registration.show();
//      }
      if(request == FrontControllScreens.MAIN){
         mainScreen.show();
      }
      else if(request == FrontControllScreens.LOGIN)
      {
         loginScreen.show();
      }
      else if(request == FrontControllScreens.MAIN_MENU)
      {
         mainMenu.show();
      }
      else if(request == FrontControllScreens.MAKE_ORDER)
      {
         makeOrderController.show();
      }
      else if(request == FrontControllScreens.ORDER_TYPE_CHOICE)
      {
         orderTypeChoiceController.show();
      }
      else if(request == FrontControllScreens.SELECT_FOOD)
      {
         foodController.show();
      }
      else if(request == FrontControllScreens.SELECT_TOPPING)
      {
         toppingsController.show();
      }
      else if(request == FrontControllScreens.SELECT_SIDE)
      {
         sideFoodController.show();
      }
      else if(request == FrontControllScreens.SELECT_DRINK)
      {
         drinksController.show();
      }
      else if(request == FrontControllScreens.SELECT_MEAL)
      {
         mealController.show();
      }
      else if(request == FrontControllScreens.ITEM_DESCRIPTION)
      {
         itemDescriptionController.show();
      }
      else{
         registration.show();
      }
   }
}