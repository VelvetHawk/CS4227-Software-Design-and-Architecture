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
      mainScreen = MainScreen.getInstance();
      loginScreen = LoginScreen.getInstance();
      registration = Registration.getInstance();
      makeOrderController = MakeOrderController.getInstance();
      mainMenu = MainMenu.getInstance();
      orderTypeChoiceController = OrderTypeChoiceController.getInstance();
      foodController = FoodController.getInstance();
      toppingsController = ToppingsController.getInstance();
      sideFoodController = SideFoodController.getInstance();
      drinksController = DrinksController.getInstance();
      mealController = MealController.getInstance();
      itemDescriptionController = ItemDescriptionController.getInstance();
   }

   public void dispatch( FrontControllScreens request){
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